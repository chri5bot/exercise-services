package com.handytec.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Activity {

	private int id;

	private String description;

	private int duration;

	private User user;

	@XmlElement(name = "desc")
	public String getDescription() {
		return description;
	}

	public int getDuration() {
		return duration;
	}

	public int getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
