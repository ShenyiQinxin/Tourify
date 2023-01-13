package com.tours;

import com.tours.twitterStream.config.TwitterConfig;
import com.tours.twitterStream.runner.StreamRunner;
import com.tours.twitterStream.runner.TwitterSearchExecutor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@Log4j2
@SpringBootApplication
@ComponentScan(basePackages = "com.tours")
public class ToursBackEndApplication implements CommandLineRunner {

	private final TwitterConfig twitterConfig;

	private final StreamRunner streamRunner;
	private final TwitterSearchExecutor twitterSearchExecutor;

	public ToursBackEndApplication(TwitterConfig twitterConfig, StreamRunner streamRunner, TwitterSearchExecutor twitterSearchExecutor) {
		this.twitterConfig = twitterConfig;
		this.streamRunner = streamRunner;
		this.twitterSearchExecutor = twitterSearchExecutor;
	}

	public static void main(String[] args) {
		SpringApplication.run(ToursBackEndApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("####################### Spring Application Started #######################");
		log.debug(Arrays.toString(twitterConfig.getTwitterKeywords().toArray(new String[] {})));
//		streamRunner.start();
		twitterSearchExecutor.start();
	}

}
