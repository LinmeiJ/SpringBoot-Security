package com.chapter2.chapter2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.chapter2.chapter2.entities.User;
import com.chapter2.chapter2.repo.UserRepository;

/*Spring Security uses this implementing -- UserDetailsService -- interface for user authentication身份验证 and authorization授权*/

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	  private UserRepository repository;


	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	    { 
	      User currentUser = repository.findByUsername(username);
	      	// Class User's constructor: User(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<GrantedAuthority> authorities) 
	      	// Construct the User with the details required by DaoAuthenticationProvider.
	        UserDetails user = new org.springframework.security.core.userdetails.User(username, currentUser.getPassword()
	        , true, true, true, true, AuthorityUtils.createAuthorityList(currentUser.getRole())); // Class AuthorityUtils(Utility method for manipulating GrantedAuthority collections etc.) => internal method: createAuthorityList(java.lang.String... roles) 
	        return user;
	    }
}
