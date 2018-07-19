package com.dawn.soundCloudexerise.utilities;

import java.util.Iterator;
import java.util.List;

import com.dawn.soundCloudexerise.resources.SoundCloudTrack;

/**
 * @author SHAHARZ
 * SoundCloudUtilities class contains methods to handle SoundCloud objects 
 * and SoundCloud Collection objects
 */
public class SoundCloudUtilities {

	/**
	 * removeTrack method searching for an element by id and remove it from the collection
	 * @param id the id to search for
	 * @param soundCloudTrackList The connection to search and remove from
	 * @return true if the element was remove, false if not
	 */
	public static boolean removeTrack(int id, List<SoundCloudTrack> soundCloudTrackList) {
		
		boolean isElementRemoved = false;
		
		for (Iterator<SoundCloudTrack> iterator = soundCloudTrackList.iterator(); iterator.hasNext();) {
		    SoundCloudTrack soundCloudTrack = iterator.next();
		    if (soundCloudTrack.getId() == id) {
		        // Remove the current element from the iterator and the list.
		        iterator.remove();
		        
		        //Mark that method removed element
		        isElementRemoved = true;
		    }
		}
		
		return isElementRemoved;
	}
	
	/**
	 * removeTrack method searching for an element by permalink_url and remove it from the collection
	 * @param permalink_url the permalink_url to search for
	 * @param soundCloudTrackList The connection to search and remove from
	 * @return true if the element was remove, false if not
	 */
	public static boolean removeTrack(String permalink_url, List<SoundCloudTrack> soundCloudTrackList) {
		
		boolean isElementRemoved = false;
		
		for (Iterator<SoundCloudTrack> iterator = soundCloudTrackList.iterator(); iterator.hasNext();) {
		    SoundCloudTrack soundCloudTrack = iterator.next();
		    if (soundCloudTrack.getPermalink_url().equals(permalink_url)) {
		        // Remove the current element from the iterator and the list.
		        iterator.remove();
		        
		        //Mark that method removed element
		        isElementRemoved = true;
		    }
		}
		
		return isElementRemoved;
	}
		
}
