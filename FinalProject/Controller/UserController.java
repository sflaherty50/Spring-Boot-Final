package com.promineotech.FinalProject.Controller;


import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.FinalProject.Entity.Credentials;
import com.promineotech.FinalProject.Service.UserService;
	@RestController
	@RequestMapping("/users")
	public class UserController {
		
		@Autowired
		private UserService userService;
		
		@RequestMapping(value="/register", method=RequestMethod.POST)
		public ResponseEntity<Object> register(@RequestBody Credentials cred){
			try {
				return new ResponseEntity<Object>(userService.register(cred), HttpStatus.CREATED);
			} catch (AuthenticationException e) {
				return new ResponseEntity<Object> (e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		}
		
		@RequestMapping(value="/login", method=RequestMethod.POST)
		public ResponseEntity<Object> login(@RequestBody Credentials cred) {
			try {
				return new ResponseEntity<Object>(userService.login(cred), HttpStatus.OK);
			}catch (AuthenticationException e) {
				return new ResponseEntity<Object>(e.getMessage(), HttpStatus.UNAUTHORIZED);
				
			}
		}
	}