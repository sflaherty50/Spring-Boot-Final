package com.promineotech.FinalProject.Service;
import javax.naming.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.promineotech.FinalProject.Entity.Credentials;
import com.promineotech.FinalProject.Entity.Users;
import com.promineotech.FinalProject.Repository.UserControllerRepository;

@Service
public class UserService {
	@Autowired
	private UserControllerRepository userControllerRepository;
	public Users register(Credentials cred) throws AuthenticationException {
		Users user = new Users();
		user.setUsername(cred.getUserName());
		user.setHash(BCrypt.hashpw(cred.getPassword(), BCrypt.gensalt()));
		try {		
		userControllerRepository.save(user);
		return user;
		} catch (DataIntegrityViolationException e) {
			throw new AuthenticationException("Username not available.");
		}
		}
	public Users login(Credentials cred) throws AuthenticationException {
		Users foundUser = userControllerRepository.findByUsername(cred.getUserName());
		if(foundUser !=null && BCrypt.checkpw(cred.getPassword(), foundUser.getHash())) {
			return foundUser;
		}
		throw new AuthenticationException("Incorrect username or password");
	}
}