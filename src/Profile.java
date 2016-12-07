package com;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Profile {
	
//	public static void main(String[] args ) {
//		System.out.println(new Profile("abc", "123456",
//				"Wenting", "Zhang", "44332211", 
//				new Date(), "London" ) );
//	}
	
	public Profile(String userName, String password ) {
		
		this.userName = userName;
		this.password = password;

		firstName = "";
		lastName = "";
		telephone = "";
		birthday = new Date();
		city = "";
//		newMessages = 0;
		lastLogin = new Date();
		profImg = null;
		
	}
	
	public Profile(String userName, String password, 
			String firstName, String lastName, String telephone,
			Date birthday, String city ) {
		
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = telephone;
		this.birthday = birthday;
		this.city = city;
//		newMessages = 0;
		lastLogin = new Date();
		profImg = "default.jpg";
		
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
//	public int getNewMessages() {
//		return newMessages;
//	}
//	public void setNewMessages(int newMessages) {
//		this.newMessages = newMessages;
//	}
	
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	public String getProfImg() {
		return profImg;
	}
	public void setProfImg(String profImg) {
		this.profImg = profImg;
	}
	
	public String toString() {
		
		return "UserName: \t" + userName + "\r\n" +
				"First Name: \t" + firstName + "\r\n" +
				"Last Name: \t" + lastName + "\r\n" +
				"Telephone: \t" + telephone + "\r\n" +
				"Birthday: \t" + new SimpleDateFormat("dd/MM/yyyy" )
					.format(birthday ) + "\r\n" +
				"City: \t" + city + "\r\n" +
				"Last Login: \t" + new SimpleDateFormat("dd/MM/yyyy" )
					.format(lastLogin) + "\r\n";
	}
	
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String telephone;
	private Date birthday;
	private String city;
//	private int newMessages;
	private Date lastLogin;
	private String profImg;
	
}
