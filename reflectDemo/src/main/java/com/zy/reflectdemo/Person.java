package com.zy.reflectdemo;

public class Person {
	private String name;
	private String sex;
	private int age;
	private String phone;
	
	
	public Person() {
		super();
	}
	
	public Person(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", sex=" + sex + ", age=" + age
				+ ", phone=" + phone + "]";
	}
	
	private  void sayHi(){
		LogKT.zy("Hi My Goddess ! ");
	}
	private  void sayHi(String str){
		LogKT.zy("Hi My Goddess ! "+str);
	}
	

}
