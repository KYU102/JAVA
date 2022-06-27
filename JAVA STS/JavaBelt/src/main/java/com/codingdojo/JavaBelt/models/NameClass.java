package com.codingdojo.JavaBelt.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name="names")
public class NameClass {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "name is required!")
	@Size(min = 3, max = 30, message = "name must be between 3 and 30 characters")
	private String babyName;
	
	@NotEmpty(message = "gender is required!")
	private String gender;

	@NotEmpty(message = "origin is required!")
	@Size(min = 8, max = 128, message = "origin must be between 8 and 128 characters")
	private String origin;
	
	@NotEmpty(message = "meaning is required!")
	@Size(min = 8, max = 128, message = "meaning must be between 8 and 128 characters")
	private String meaning;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
	

	// EMPTY CONSTRUCTOR
	public NameClass() {
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getbabyName() {
		return babyName;
	}


	public void setbabyName(String babyName) {
		this.babyName = babyName;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getOrigin() {
		return origin;
	}


	public void setOrigin(String origin) {
		this.origin = origin;
	}


	public String getMeaning() {
		return meaning;
	}


	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	

}
