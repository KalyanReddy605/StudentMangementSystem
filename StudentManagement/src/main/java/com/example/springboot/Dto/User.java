package com.example.springboot.Dto;

import java.time.LocalDateTime;

public class User {

    
    private Long id;

    private String name;

    private String email;

    private String mobile;

    private String password;

    private String linkId;

    private LocalDateTime creationOn;

    private Boolean isActive;

    private Boolean isEmailVerified;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLinkId() {
		return linkId;
	}

	public void setLinkId(String linkId) {
		this.linkId = linkId;
	}

	public LocalDateTime getCreationOn() {
		return creationOn;
	}

	public void setCreationOn(LocalDateTime creationOn) {
		this.creationOn = creationOn;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsEmailVerified() {
		return isEmailVerified;
	}

	public void setIsEmailVerified(Boolean isEmailVerified) {
		this.isEmailVerified = isEmailVerified;
	}

	public User(Long id, String name, String email, String mobile, String password, String linkId,
			LocalDateTime creationOn, Boolean isActive, Boolean isEmailVerified) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.linkId = linkId;
		this.creationOn = creationOn;
		this.isActive = isActive;
		this.isEmailVerified = isEmailVerified;
	}

	public User() {
		super();
	}
    
    
}

