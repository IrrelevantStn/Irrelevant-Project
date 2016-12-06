package com;


import java.util.Calendar;



public class Profile {
	
	public static void main(String[] args ) {
		System.out.println(new Profile("abc", "123456",
				"Wenting", "Zhang", "44332211", 
				Calendar.getInstance(), "London",Calendar.getInstance(),"" ) );
	}
	
	public Profile(String userName, String password ) {
		
		this.userName = userName;
		this.password = password;

		firstName = "";
		surname = "";
		telephone = "";
		birthday = null;
		city = "";
		lastLogin = null;
		profImg = null;
		
	}
	
	public Profile(String userName, String password, 
			String firstName, String surname, String telephone,
			Calendar birthday, String city, Calendar lastLogin, String profImg ) {
		
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.surname = surname;
		this.telephone = telephone;
		this.birthday = birthday;
		this.city = city;
		this.lastLogin = lastLogin;
		this.profImg = profImg;
		
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
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public Calendar getBirthday() {
		return birthday;
	}
	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public Calendar getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Calendar lastLogin) {
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
				"Last Name: \t" + surname + "\r\n" +
				"Telephone: \t" + telephone + "\r\n" +
				"Birthday: \t" + lastLogin.get(Calendar.DATE) +
				"/" + lastLogin.get(Calendar.MONTH)
				+ "/" + lastLogin.get(Calendar.YEAR) + "\r\n" +
				"City: \t\t" + city + "\r\n" +
				"Last Login: \t" + lastLogin.get(Calendar.DATE) +
				"/" + lastLogin.get(Calendar.MONTH)
				+ "/" + lastLogin.get(Calendar.YEAR) + "\r\n" + "ProfImg: \t" + profImg;
	}
	
	private String userName;
	private String password;
	private String firstName;
	private String surname;
	private String telephone;
	private Calendar birthday;
	private String city;
	private Calendar lastLogin;
	private String profImg;
	
}
