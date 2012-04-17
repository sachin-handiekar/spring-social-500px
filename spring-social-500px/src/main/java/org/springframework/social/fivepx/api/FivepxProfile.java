package org.springframework.social.fivepx.api;

import java.io.Serializable;
import java.util.Date;

public class FivepxProfile implements Serializable {

	private static final long serialVersionUID = 1L;

	private final long id;

	private final String userName;

	private final String name;

	private final String userpicUrl;

	private String about;

	private String domain;

	private String city;

	private String country;

	private String sex;

	private int followersCount;

	private int inFavouritesCount;
	
	private int friendsCount;


	private int affection;

	private Date registrationDate;

	public FivepxProfile(long id, String userName, String name, String userpicUrl) {
		super();
		this.id = id;
		this.userName = userName;
		this.name = name;
		this.userpicUrl = userpicUrl;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	 

	public int getFollowersCount() {
		return followersCount;
	}

	public void setFollowersCount(int followersCount) {
		this.followersCount = followersCount;
	}

	public int getInFavouritesCount() {
		return inFavouritesCount;
	}

	public void setInFavouritesCount(int inFavouritesCount) {
		this.inFavouritesCount = inFavouritesCount;
	}

	public int getAffection() {
		return affection;
	}

	public void setAffection(int affection) {
		this.affection = affection;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getName() {
		return name;
	}

	public String getUserpicUrl() {
		return userpicUrl;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getFriendsCount() {
		return friendsCount;
	}

	public void setFriendsCount(int friendsCount) {
		this.friendsCount = friendsCount;
	}

}
