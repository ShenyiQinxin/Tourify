package com.tours.twitterStream.listener;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import twitter4j.Status;
import twitter4j.StatusAdapter;

@Log4j2
@Component
public class TwitterStreamListener extends StatusAdapter {

    public void onStatus(Status status) {
        log.info("Twitter text: {}", status.getText(), status.getGeoLocation());
        if (status.getGeoLocation() != null) {
            log.info("Twitter geo location: {}", status.getGeoLocation());
        }
        if (status.getPlace() != null) {
            log.info("Twitter place: {}", status.getPlace());
        }

        log.info("Twitter created at: {}", status.getCreatedAt());
        log.info("Twitter favorite count: {}", status.getFavoriteCount());

    }
}
