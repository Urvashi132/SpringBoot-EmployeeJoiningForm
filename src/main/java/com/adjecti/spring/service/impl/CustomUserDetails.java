package com.adjecti.spring.service.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.adjecti.spring.configuration.Authority;
import com.adjecti.spring.entity.Role;
import com.adjecti.spring.entity.User;

public class CustomUserDetails implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	private User user;
	private Set<Role> roles;
	
	public CustomUserDetails(User user, Set<Role> roles) {
		super();
		this.user = user;
		this.roles = roles;
	}

	public CustomUserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomUserDetails(User user) {
		super();
		this.user = user;
		this.roles = user.getUserRole();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		try {
			Set<Authority> roles=new HashSet<>();
			this.roles.forEach(role -> {
				roles.add(new Authority(role.getRole()));
			});
			return roles;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
