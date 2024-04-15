package com.rubypaper.dto;

public class FriendDTO {
	private int num;
	private String name;
	private String mobile;
	private String charcter;
	
	@Override
	public String toString() {
		return "FriendDTO [num=" + num + ", name=" + name + ", mobile=" + mobile + ", charcter=" + charcter + "]";
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCharcter() {
		return charcter;
	}
	public void setCharcter(String charcter) {
		this.charcter = charcter;
	}
}
