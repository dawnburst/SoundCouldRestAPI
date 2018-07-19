package com.dawn.soundCloudexerise.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.dawn.soundCloudexerise.controller.SoundCloudLookupService;
import com.dawn.soundCloudexerise.resources.SoundCloudTrack;
import com.dawn.soundCloudexerise.utilities.SoundCloudUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;


@Component
public class AppRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    private final SoundCloudLookupService soundCloudLookupService;

    public AppRunner(SoundCloudLookupService soundCloudLookupService) {
        this.soundCloudLookupService = soundCloudLookupService;
    }
    
    @Override
    public void run(String... args) throws Exception {
        // Start the clock
        long start = System.currentTimeMillis();
        
        // Kick of multiple, asynchronous lookups
        CompletableFuture<List<SoundCloudTrack>> request1 = soundCloudLookupService.getTrackData("U2");
        CompletableFuture<List<SoundCloudTrack>> request2 = soundCloudLookupService.getTrackData("Pixes");
        CompletableFuture<List<SoundCloudTrack>> request3 = soundCloudLookupService.getTrackData("Pearl Jam");

        // Wait until they are all done
        CompletableFuture.allOf(request1,request2,request3).join();
        
        //Create 1 list to store the results from all requests 
        List<SoundCloudTrack> soundCloudTrackAllList = new ArrayList<>();
        soundCloudTrackAllList.addAll(request1.get());
        soundCloudTrackAllList.addAll(request2.get());
        soundCloudTrackAllList.addAll(request3.get());
        
        //Sort the collection by title
        Collections.sort(soundCloudTrackAllList, (SoundCloudTrack t1, SoundCloudTrack t2) -> t1.getTitle().compareTo(t2.getTitle()));
        
        // Print results, including elapsed time
        logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
        for (SoundCloudTrack soundCloudTrack : soundCloudTrackAllList) {
        	logger.info("--> " + soundCloudTrack);
		}
        
        //Removing track by id
        logger.info("removing track by id 64174057");
        logger.info((SoundCloudUtilities.removeTrack(64174057, soundCloudTrackAllList) ? "64174057 track removed" : "64174057 track not removed"));

        //Removing track by permalink_url        
        logger.info("removing track by permalink_url https://soundcloud.com/you-two/u2-sunday-bloody-sunday");
        logger.info((SoundCloudUtilities.removeTrack("https://soundcloud.com/you-two/u2-sunday-bloody-sunday", soundCloudTrackAllList) 
        		? "https://soundcloud.com/you-two/u2-sunday-bloody-sunday track removed" 
        		: "https://soundcloud.com/you-two/u2-sunday-bloody-sunday track not removed"));
        
        //Printing to log all tracks after removing elements
        for (SoundCloudTrack soundCloudTrack : soundCloudTrackAllList) {
        	logger.info("--> " + soundCloudTrack);
		}

    }
	
}
