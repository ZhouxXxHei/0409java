package com.offcn.po;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="user")
public class User {

	private String userid;
	private String name;
	private String password;
	private int age;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "user [userid=" + userid + ", name=" + name + ", password=" + password + ", age=" + age + "]";
	}
	
	
}
