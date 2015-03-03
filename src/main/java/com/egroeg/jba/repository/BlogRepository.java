package com.egroeg.jba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egroeg.jba.entity.Blog;
import com.egroeg.jba.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer>{
	
	List<Blog> findByUser(User user); 
		
	

}
