package com.tours.toursbackend.twitterStream.runner;

import com.tours.toursbackend.twitterStream.config.TwitterConfig;
import com.tours.toursbackend.twitterStream.listener.TwitterStreamListener;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import twitter4j.FilterQuery;
import twitter4j.TwitterStream;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@Component
@ConditionalOnProperty(name="twitter.to.kafka.enable.v2.tweets", havingValue = "true", matchIfMissing = true)
public class TwitterStreamRunner implements StreamRunner{

    private final TwitterConfig twitterConfig;

    private final TwitterV2StreamHelper twitterV2StreamHelper;


    private TwitterStream twitterStream;

    public TwitterStreamRunner(TwitterConfig twitterConfig, TwitterV2StreamHelper twitterV2StreamHelper) {
        this.twitterConfig = twitterConfig;
        this.twitterV2StreamHelper = twitterV2StreamHelper;
    }

    @Override
    public void start() {
        String bearerToken = twitterConfig.getTwitterV2BearerToken();
        if (null != bearerToken) {
            try {
                twitterV2StreamHelper.setupRules(bearerToken, getRules());
                twitterV2StreamHelper.connectStream(bearerToken);
            } catch (IOException | URISyntaxException e) {
                log.error("Error streaming tweets!", e);
                throw new RuntimeException("Error streaming tweets!", e);
            }
        } else {
            log.error("There was a problem getting your bearer token. " +
                    "Please make sure you set the TWITTER_BEARER_TOKEN environment variable");
            throw new RuntimeException("There was a problem getting your bearer token. +" +
                    "Please make sure you set the TWITTER_BEARER_TOKEN environment variable");
        }
    }

    private Map<String, String> getRules() {
        List<String> keywords = twitterConfig.getTwitterKeywords();
        Map<String, String> rules = new HashMap<>();
        for (String keyword: keywords) {
            rules.put(keyword, "Keyword: " + keyword);
        }
        log.info("Created filter for twitter stream for keywords: {}", keywords);
        return rules;
    }
}
