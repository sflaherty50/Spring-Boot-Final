package com.promineotech.FinalProject.Repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.FinalProject.Entity.Users;

public interface UserControllerRepository extends CrudRepository<Users, Long> {

	 public Users findByUsername(String UserName);

}

