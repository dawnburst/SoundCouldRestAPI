package com.dawn.soundCloudexerise.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.dawn.soundCloudexerise.resources.SoundCloudTrack;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;


/**
 * 
 * @author SHAHARZ
 * SoundCloudLookupService class provide search service from SoundCloud API
 * The class is marked with the @Service annotation, making it a candidate for 
 * Spring’s component scanning to detect it and add it to the application context.
 */
@Service
public class SoundCloudLookupService {

	private static final Logger logger = LoggerFactory.getLogger(SoundCloudLookupService.class);

	//RestTemplate makes interacting with RESTful services 
	private final RestTemplate restTemplate;

	public SoundCloudLookupService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}


	//The getTrackData method is flagged with Spring’s @Async annotation, indicating it will run on a separate thread. 
	@Async
	public CompletableFuture<List<SoundCloudTrack>> getTrackData(String query) throws InterruptedException, JsonParseException, JsonMappingException, IOException {
		
		//Limits the result from api to 10 rows only
		final int LIMIT = 10;
		
		//Concatenate parameters in order to build url string to get track from soundcloud api  
		String url = "http://api.soundcloud.com/tracks/?limit=" + LIMIT + "&q=" + query + "&client_id=pCNN85KHlpoe5K6ZlysWZBEgLJRcftOd";

		//Create timestamp
	    long yourmilliseconds = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");    
        Date currentDateTime = new Date(yourmilliseconds);
		
		logger.info(currentDateTime + " Performing query: " + url);
		

		//Sending get request to soundcloud api - expecting to get in return json
		RestTemplate restTemplate = new RestTemplate();
		String soundCloudJson = restTemplate.getForObject(url, String.class);

		//Parsing the json string into an objects
		ObjectMapper objectMapper = new ObjectMapper();
		List<SoundCloudTrack> soundCloudTracklist = objectMapper.readValue(soundCloudJson, new TypeReference<List<SoundCloudTrack>>(){});


		// Artificial delay of 1 - 5 seconds for demonstration purposes
		Random random = new Random();
		long milisecondsRandomNum = random.nextInt((5000 - 1000) + 1) + 1000;
		Thread.sleep(milisecondsRandomNum);
		
		return CompletableFuture.completedFuture(soundCloudTracklist);
	}

}

