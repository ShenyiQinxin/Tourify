package com.tours.twitterStream.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "twitter-to-kafka")
public class TwitterConfig {
    private List<String> twitterKeywords;
    private String enableV2Tweets;
    private String twitterV2StreamUrl;
    private String twitterV2RulesBaseUrl;
    private String twitterV2RecentTweetsUrl;
    private String twitterV2BearerToken;
    private String twitterQuery;
    private List<String> twitterFields;


}
