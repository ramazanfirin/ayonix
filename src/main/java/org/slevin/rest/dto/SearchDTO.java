package org.slevin.rest.dto;

import org.slevin.common.FaceMatcherPerson;

public class SearchDTO {
	Long id;
	String name;
	String score;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	
	
	
}
