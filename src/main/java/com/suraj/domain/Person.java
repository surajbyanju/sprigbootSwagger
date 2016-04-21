package com.suraj.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class Person {
	
	private long id;
	private String firstName;
	private String LastName;
	
	
	
	
	public Person(long id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		LastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	
	@JsonProperty(required = true)
	@ApiModelProperty(notes = "The id of the user", required = true)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	

	

}
