package com.adjecti.spring.dto;

import java.util.HashSet;
import java.util.Set;

import com.adjecti.spring.entity.Role;

public class UserDTO {
	private String username;
	private String password;
	private boolean enabled;
	private Set<Role> userRole=new HashSet<>();
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Set<Role> getRole() {
		return userRole;
	}
	public void setRole(Set<Role> userRole) {
		this.userRole = userRole;
	}
	public UserDTO(String username, String password, boolean enabled, Set<Role> userRole) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.userRole = userRole;
	}
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
