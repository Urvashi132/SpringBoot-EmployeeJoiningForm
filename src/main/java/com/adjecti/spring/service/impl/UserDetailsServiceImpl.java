package com.adjecti.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.adjecti.spring.entity.User;
import com.adjecti.spring.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired 
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User userRepo=repository.findByusername(username);
		CustomUserDetails customUserDetails=null;
		if(userRepo==null) {
			throw new UsernameNotFoundException("User does not Found");
		}
		customUserDetails=new CustomUserDetails(userRepo);
		return customUserDetails;
	}

	/*
	 * @Autowired private UserRepository repository;
	 * 
	 * public UserRepository getUserRepo() { return repository; }
	 * 
	 * public void setUserRepo(UserRepository repository) { this.repository =
	 * repository; }
	 * 
	 * public UserDetails loadUserByUsername(String empcode) throws
	 * UsernameNotFoundException { System.out.println(empcode +
	 * "<<<<<<<<<<<----------------username"); com.adjecti.spring.admin.model.User
	 * user=repository.findByempcode(empcode); System.out.println(user.getPassword()
	 * + "<>><><><><><><<><><"); String empCode = user.getEmpcode(); if(empCode ==
	 * null){ throw new UsernameNotFoundException("User not authorized."); }
	 * 
	 * 
	 * List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());
	 * 
	 * System.out.println("userRole "+user.getUserRole());
	 * 
	 * 
	 * 
	 * return buildUserForAuthentication(user, authorities); }
	 * 
	 * // Converts org.adj.amgmt.entity.User user to // //
	 * org.springframework.security.core.userdetails.User
	 * 
	 * private User buildUserForAuthentication(com.adjecti.spring.admin.model.User
	 * user, List<GrantedAuthority> authorities) {
	 * System.out.println(user.getEmpcode() + "<--------------"); return new
	 * User(user.getEmpcode(), user.getPassword(), user.isEnabled(), true, true,
	 * true, authorities); }
	 * 
	 * private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
	 * 
	 * Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
	 * 
	 * // Build user's authorities for (UserRole userRole : userRoles) {
	 * setAuths.add(new SimpleGrantedAuthority(userRole.getRole())); }
	 * 
	 * List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
	 * 
	 * return Result; }
	 */
}
