package com.contact.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer contactid;
	
	@Column(name="userid")
	private Integer userid; // foreign key
	
	private String name;
	private String nickname;
	private String phonenumber;
	private String description;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getcontactid() {
		return contactid;
	}
	public void setcontactid(Integer contactid) {
		this.contactid = contactid;
	}
	public String getNickName() {
		return nickname;
	}
	public void setNickName(String nickname) {
		this.nickname = nickname;
	}
	public String getPhoneNumber() {
		return phonenumber;
	}
	public void setPhoneNumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getU_id() {
		return userid;
	}
	public void setU_id(Integer u_id) {
		this.userid = u_id;
	}
	@Override
	public String toString() {
		return "Contact [c_id=" + contactid + ", userid=" + userid + ", name=" + name + ", nickname=" + nickname
				+ ", phonenumber=" + phonenumber + ", description=" + description + "]";
	}
	

}
