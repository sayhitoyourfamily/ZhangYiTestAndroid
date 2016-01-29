package model;

import myinterface.Action;

/**
 * @author zhangyi
 *
 * TODO  人，所有人的父类
 */
public abstract class Person implements Action{
	/**
	 * 名字
	 */
	private String name;
	/**
	 * 性别 0女，1男
	 */
	private int sex;
	
	/**
	 * 年龄
	 */
	private int age;
	

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	
	
	
}
