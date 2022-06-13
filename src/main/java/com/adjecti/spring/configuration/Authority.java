package com.adjecti.spring.configuration;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority{
	private static final long serialVersionUID = 1L;

	private String authority;
	
	public Authority(String authority) {
		super();
		this.authority=authority;
	}

	@Override
	public String getAuthority() {
		return authority;
	}

}
