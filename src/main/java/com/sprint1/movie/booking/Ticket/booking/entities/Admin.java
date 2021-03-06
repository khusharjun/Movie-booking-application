package com.sprint1.movie.booking.Ticket.booking.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    //Fields
	private int adminId;
	@Column(nullable = false)
	private String adminName;
	@Column(nullable = false)
	private String adminContact;
	
	@OneToOne(cascade=CascadeType.ALL,targetEntity = User.class,orphanRemoval = true)
	User user;

	//Constructors
	public Admin() {
		super();
	}
	public Admin(int adminId, String adminName, String adminContact) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminContact = adminContact;
	}
	public Admin(String adminName, String adminContact) {
		super();
		this.adminName = adminName;
		this.adminContact = adminContact;
	}
	
	public Admin(int adminId, String adminName, String adminContact, User user) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminContact = adminContact;
		this.user = user;
	}
	//Getters and setters
	public int getadminId() {
		return adminId;
	}
	public void setadminId(int adminId) {
		this.adminId = adminId;
	}
	
	
	public String getadminName() {
		return adminName;
	}
	public void setadminName(String adminName) {
		this.adminName = adminName;
	}
	public String getadminContact() {
		return adminContact;
	}
	public void setadminContact(String adminContact) {
		this.adminContact = adminContact;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adminContact == null) ? 0 : adminContact.hashCode());
		result = prime * result + ((adminName == null) ? 0 : adminName.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		if (adminContact == null) {
			if (other.adminContact != null)
				return false;
		} else if (!adminContact.equals(other.adminContact))
			return false;
		if (adminName == null) {
			if (other.adminName != null)
				return false;
		} else if (!adminName.equals(other.adminName))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminContact=" + adminContact + ", user="
				+ user + "]";
	}
    
}