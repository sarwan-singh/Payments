package com.dbs.spring.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.spring.model.AuthenticationRequest;
import com.dbs.spring.model.AuthenticationResponse;
import com.dbs.spring.service.CustomerUserDetailsService;
import com.dbs.spring.util.JwtUtil;


@RestController
@CrossOrigin
public class JwtController {

	@Autowired
	private CustomerUserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/auth")
	public ResponseEntity<AuthenticationResponse> authenticateCustomer(
			@RequestBody AuthenticationRequest request) throws Exception
	{
		System.out.println("Login attempt with username : " + request.getUsername());
		try {
			manager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), 
							request.getPassword()));
		}
		catch(BadCredentialsException e)
		{
			return ResponseEntity.ok(new AuthenticationResponse(false, "Authentication failed"));
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
		final String jwt = jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(true, jwt));
	}
	
	@PostMapping("/sessioncheck")
	public ResponseEntity<Object> sessionCheck(@RequestBody AuthenticationResponse request){
	
		try {
			boolean status = jwtUtil.extractExpiration(request.getJwt()).before(new Date());
			
			if(status) {
				return ResponseEntity
						.status(HttpStatus.BAD_REQUEST)
						.body(new ResponsePage(false, null, "Session expired"));
			}else {
				return ResponseEntity
						.status(HttpStatus.BAD_REQUEST)
						.body(new ResponsePage(true, null, "Authenticated"));
			}
		
		}catch(Exception e) {
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(new ResponsePage(false, null, "Token altered"));
		}
		
	}
}
