package com.xylu.contactdemo;

public class Contact {

	/** 联系人名称 **/
	private String name;
	/** 联系人号码 **/
	private String number;
	
	public Contact(String name, String number) {
		this.name = name;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
}
