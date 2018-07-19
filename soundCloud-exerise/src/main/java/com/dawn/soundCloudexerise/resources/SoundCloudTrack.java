package com.dawn.soundCloudexerise.resources;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SoundCloudTrack {

	private int id;
	private String title;
	private String permalink_url;
	private User user;

	public SoundCloudTrack() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SoundCloudTrack(int id, String title, String permalink_url, User user) {
		super();
		this.id = id;
		this.title = title;
		this.permalink_url = permalink_url;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPermalink_url() {
		return permalink_url;
	}

	public void setPermalink_url(String permalink_url) {
		this.permalink_url = permalink_url;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "SoundCloudTrack [id=" + id + ", title=" + title + ", permalink_url=" + permalink_url + ", user=" + user
				+ "]";
	}

	
}
