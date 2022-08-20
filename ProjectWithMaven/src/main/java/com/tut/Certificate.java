package com.tut;

import javax.persistence.Embeddable;

@Embeddable
public class Certificate {
	
	/*
	 * If We want this class feilds to be created as column in some other 
	 * Entity table , then we will make this class as @Embeddable
	 */
	
	private String course;
	
	private String duration;

	public Certificate(String course, String duration) {
		super();
		this.course = course;
		this.duration = duration;
	}

	public Certificate() {
		super();
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	

	
}
