package com.hxd.bean.common;

/**
 * Created by Hu on 2017/7/7.
 */
public class UserDemo {

	private int id;
	private String name;
	private int age;

	public UserDemo(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public UserDemo() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}
