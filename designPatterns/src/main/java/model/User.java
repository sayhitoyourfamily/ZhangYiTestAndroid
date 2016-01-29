package model;

import utils.LogKT;

public class User extends Person {

	/**
	 * 用户id
	 */
	private int id;
	/**
	 * 编号
	 */
	private String number;
	
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 电话号码
	 */
	private int phoneNumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public void say() {
		LogKT.zy("user is god");		
	}
	@Override
	public void walk() {
		LogKT.zy("oooooo");		
	}

	
}
