package com.tours.twitterStream.runner;


import twitter4j.TwitterException;

public interface StreamRunner {
    void start() throws TwitterException;
}
