package com.tours.toursbackend.twitterStream.runner;

import com.tours.toursbackend.twitterStream.config.TwitterConfig;
import com.tours.toursbackend.twitterStream.listener.TwitterStreamListener;
import com.tours.toursbackend.twitterStream.model.RequestParams;
import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;

@Log4j2
@Component
@ConditionalOnProperty(name="twitter.to.kafka.enable.v2.tweets", havingValue = "true", matchIfMissing = true)
public class TwitterV2TweetsHelper {
    private final TwitterConfig twitterConfig;

    private final TwitterStreamListener twitterStreamListener;

    private static final String TWITTER_STATUS_DATE_FORMAT = "EEE MMM dd HH:mm:ss zzz yyyy";

    private static final String tweetAsRawJson = "{" +
            "\"created_at\":\"{0}\"," +
            "\"id\":\"{1}\"," +
            "\"text\":\"{2}\"," +
            "\"user\":{\"id\":\"{3}\"}" +
            "}";

    public TwitterV2TweetsHelper(TwitterConfig twitterConfig, TwitterStreamListener twitterStreamListener) {
        this.twitterConfig = twitterConfig;
        this.twitterStreamListener = twitterStreamListener;
    }

    /*
     * This method calls the full-archive search endpoint with a search term passed to it as a query parameter
     * */
    public void searchRecent(RequestParams requestParams, String bearerToken) throws IOException, URISyntaxException {
        String searchResponse = null;

        HttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setCookieSpec(CookieSpecs.STANDARD).build())
                .build();

        URIBuilder uriBuilder = new URIBuilder(twitterConfig.getTwitterV2RecentTweetsUrl());
        ArrayList<NameValuePair> queryParameters;
        queryParameters = new ArrayList<>();
        queryParameters.add(new BasicNameValuePair("query", requestParams.getQuery()));
        queryParameters.add(new BasicNameValuePair("tweet.fields", requestParams.getTweetFieldsString()));
        uriBuilder.addParameters(queryParameters);

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("Authorization", String.format("Bearer %s", bearerToken));
        httpGet.setHeader("Content-Type", "application/json");

        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        if (null != entity) {
            searchResponse = EntityUtils.toString(entity, "UTF-8");
            log.info(searchResponse);
        }
    }
}
