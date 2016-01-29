package model;

import utils.LogKT;

public class Student extends Person{
	/**
	 * 编号
	 */
	private String number;

	@Override
	public void say() {
		LogKT.zy("I am a stuudent");
	}

	@Override
	public void walk() {
		LogKT.zy("kakakaka...");
	}
}
