package com.tours.toursbackend.twitterStream.model;

import com.tours.toursbackend.twitterStream.config.TwitterConfig;
import lombok.Getter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Component
@ConditionalOnProperty(name="twitter.to.kafka.enable.v2.tweets", havingValue = "true", matchIfMissing = true)
public class RequestParams {

    private final TwitterConfig twitterConfig;

    private String query;
    private List<String> tweetFields;
    private String expansions;
    private List<String> mediaFields;

    public RequestParams(TwitterConfig twitterConfig) {
        this.twitterConfig = twitterConfig;
        query = twitterConfig.getTwitterQuery();
        tweetFields = twitterConfig.getTwitterFields();
    }


    public String getTweetFieldsString() {
        StringBuilder tweetFieldsString = new StringBuilder();
        for (String field: tweetFields
             ) {
            tweetFieldsString.append(field).append(",");
        }
        return tweetFieldsString.substring(0, tweetFieldsString.length()-1).toString();
    }
}
