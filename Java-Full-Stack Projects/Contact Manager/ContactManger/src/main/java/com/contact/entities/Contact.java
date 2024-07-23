package com.contact.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//This is the Contact entity, which represents each contact in the system
@Entity
public class Contact {
	
	//The @Id annotation indicates that this field is a primary key.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//This auto-increments the contact id each time a new contact is added.
	private Integer contactid;
	
	// This many-to-one relationship allows each contact to belong to a user.
	@Column(name="userid")
	private Integer userid; 
	
	private String name;
	private String nickname;
	private String phonenumber;
	private String description;
	
	// Getters and Setters
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
	// toString method to override for displaying the object data in a clear way. This is helpful in debugging.
	@Override
	public String toString() {
		return "Contact [c_id=" + contactid + ", userid=" + userid + ", name=" + name + ", nickname=" + nickname
				+ ", phonenumber=" + phonenumber + ", description=" + description + "]";
	}
	

}
