package com.dbs.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dbs.spring.model.CustomerUser;
import com.dbs.spring.repository.CustomerUserRepository;
@Service()
public class CustomerUserDetailsService implements UserDetailsService{
	@Autowired
	private CustomerUserRepository repo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<CustomerUser> opt = this.repo.findByUsername(username);
		return opt.map(customerUser ->{
			List<String> l = new ArrayList<>();
			l.add("ROLE_USER");
			User user = new User(customerUser.getUsername(),
					encoder.encode(customerUser.getUserpassword()), 
					l.stream()
					.map(role -> new SimpleGrantedAuthority(role))
					.collect(Collectors.toList()));
					
					return user;
		}).orElseThrow(()-> new UsernameNotFoundException("User does not exist"));
		
	}
	
}
