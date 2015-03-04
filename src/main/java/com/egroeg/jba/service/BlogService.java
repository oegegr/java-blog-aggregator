package com.egroeg.jba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.egroeg.jba.entity.Blog;
import com.egroeg.jba.entity.User;
import com.egroeg.jba.repository.BlogRepository;
import com.egroeg.jba.repository.UserRepository;


@Service
public class BlogService {
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private UserRepository userRepository;

	public void save(Blog blog, String name) {
		// TODO Auto-generated method stub
		User user = userRepository.findByName(name); 
		blog.setUser(user);
		blogRepository.save(blog);
	}

	@PreAuthorize("#blog.user.name == authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(@P("blog") Blog blog) {
		// TODO Auto-generated method stub
		blogRepository.delete(blog);
		
	}

	public Blog findOne(int id) {
		return blogRepository.findOne(id);
	}

}
