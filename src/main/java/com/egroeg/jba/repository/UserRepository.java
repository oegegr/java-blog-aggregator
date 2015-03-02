package com.egroeg.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egroeg.jba.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
