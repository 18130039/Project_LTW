package edu.beans;

public class Account {
	private String userName;
	private String passWord;
	private String nameOfCustomer;
	private String sex;
	private String phoneNumber;
	private String email;
	private String dayOfBirth;
	private String address;
	private String role;

	public Account() {
	}

	public Account(String userName, String passWord, String nameOfCustomer, String sex, String phoneNumber,
			String email, String dayOfBirth, String address, String role) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.nameOfCustomer = nameOfCustomer;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.dayOfBirth = dayOfBirth;
		this.address = address;
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getNameOfCustomer() {
		return nameOfCustomer;
	}

	public void setNameOfCustomer(String nameOfCustomer) {
		this.nameOfCustomer = nameOfCustomer;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDayOfBirth() {
		return dayOfBirth;
	}

	public void setDayOfBirth(String dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Account [userName=" + userName + ", passWord=" + passWord + ", nameOfCustomer=" + nameOfCustomer
				+ ", sex=" + sex + ", phoneNumber=" + phoneNumber + ", email=" + email + ", dayOfBirth=" + dayOfBirth
				+ ", address=" + address + ", role=" + role + "]" + "\n";
	}

}
