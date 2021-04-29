package com.advertise.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.advertise.in.model.RegisterUserEntity;

@Repository
public interface RegisterUserRepo extends JpaRepository<RegisterUserEntity, Integer > {

	public RegisterUserEntity findByEmailId(String emailId);
}
