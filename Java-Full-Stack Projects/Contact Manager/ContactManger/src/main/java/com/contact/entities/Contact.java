package com.contact.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Contact {
	
	@Id
	private String c_id;
	
	@Column(name="userid")
	private String userid; // foreign key
	
	private String name;
	private String nickName;
	private String phoneNumber;
	private String description;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getU_id() {
		return userid;
	}
	public void setU_id(String u_id) {
		this.userid = u_id;
	}
	@Override
	public String toString() {
		return "Contact [c_id=" + c_id + ", userid=" + userid + ", name=" + name + ", nickName=" + nickName
				+ ", phoneNumber=" + phoneNumber + ", description=" + description + "]";
	}
	

}
