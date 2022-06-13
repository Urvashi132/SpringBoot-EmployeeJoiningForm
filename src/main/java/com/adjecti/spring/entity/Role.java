
package com.adjecti.spring.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id", nullable = false)
	private Integer role_id;

	private String role;
	/*
	 * @ManyToOne(cascade = CascadeType.ALL ,fetch = FetchType.EAGER) private User
	 * user;
	 */
	
	

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	/*
	 * public User getUser() { return user; }
	 * 
	 * public void setUser(User user) { this.user = user; }
	 */

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	public Role() {
		super();

	}
	public  Role(String role) {
		this.role=role;
	}

	public Role(Integer role_id, String role/* , User user */) {
		super();
		this.role_id = role_id;
		this.role = role;
	//	this.user = user;
	}

	@Override
	public String toString() {
		return "UserRole [role_id=" + role_id + ", role=" + role + ", user=" + /* user + */ "]";
	}

}
