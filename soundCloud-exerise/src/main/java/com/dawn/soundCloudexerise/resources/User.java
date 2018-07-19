package com.dawn.soundCloudexerise.resources;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

	private int id;
	private String permalink;
	private String username;
	private String uri;
	private String permalink_url;
	private String avatar_url;
	private String kind;
	private String last_modified;
	
	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPermalink() {
		return permalink;
	}

	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getPermalink_url() {
		return permalink_url;
	}

	public void setPermalink_url(String permalink_url) {
		this.permalink_url = permalink_url;
	}

	public String getAvatar_url() {
		return avatar_url;
	}

	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getLast_modified() {
		return last_modified;
	}

	public void setLast_modified(String last_modified) {
		this.last_modified = last_modified;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", permalink=" + permalink + ", username=" + username + ", uri=" + uri
				+ ", permalink_url=" + permalink_url + ", avatar_url=" + avatar_url + ", kind=" + kind
				+ ", last_modified=" + last_modified + "]";
	}

}
