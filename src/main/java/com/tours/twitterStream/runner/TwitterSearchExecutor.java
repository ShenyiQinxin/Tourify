package com.tours.twitterStream.runner;

import com.tours.twitterStream.config.TwitterConfig;
import com.tours.twitterStream.model.RequestParams;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import twitter4j.TwitterException;

import java.io.IOException;
import java.net.URISyntaxException;

@Log4j2
@Component
@ConditionalOnProperty(name="twitter.to.kafka.enable.v2.tweets", havingValue = "true", matchIfMissing = true)
public class TwitterSearchExecutor {
    public static final String BEARER_TOKEN_ERROR = "There was a problem getting your bearer token. " +
            "Please make sure you set the TWITTER_BEARER_TOKEN environment variable";
    public static final String ERROR_SEARCHING_TWEETS = "Error searching tweets!";

    private final TwitterConfig twitterConfig;
    private final TwitterV2TweetsHelper twitterV2TweetsHelper;

    private final RequestParams requestParams;

    public TwitterSearchExecutor(TwitterConfig twitterConfig, TwitterV2TweetsHelper twitterV2TweetsHelper, RequestParams requestParams) {
        this.twitterConfig = twitterConfig;
        this.twitterV2TweetsHelper = twitterV2TweetsHelper;
        this.requestParams = requestParams;
    }

//    @Override
    public void start() throws TwitterException {
        String bearerToken = twitterConfig.getTwitterV2BearerToken();
        if (null != bearerToken && !twitterConfig.getTwitterKeywords().isEmpty()) {
            try {
                twitterV2TweetsHelper.searchRecent(requestParams, bearerToken);

            } catch (IOException | URISyntaxException e) {
                log.error(ERROR_SEARCHING_TWEETS, e);
                throw new RuntimeException(ERROR_SEARCHING_TWEETS, e);
            }
        } else {
            log.error(BEARER_TOKEN_ERROR);
            throw new RuntimeException(BEARER_TOKEN_ERROR);
        }
    }
}
