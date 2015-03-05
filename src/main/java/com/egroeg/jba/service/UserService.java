package com.egroeg.jba.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.egroeg.jba.entity.Blog;
import com.egroeg.jba.entity.Item;
import com.egroeg.jba.entity.Role;
import com.egroeg.jba.entity.User;
import com.egroeg.jba.repository.BlogRepository;
import com.egroeg.jba.repository.ItemRepository;
import com.egroeg.jba.repository.RoleRepository;
import com.egroeg.jba.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findOne(int id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

	@Transactional
	public User findOneWithBlogs(int id) {
		// TODO Auto-generated method stub
		User user = findOne(id);
		List<Blog> blogs = blogRepository.findByUser(user);
		for (Blog blog : blogs) {
			List<Item> items = itemRepository.findByBlog(blog, new PageRequest(0, 10, Direction.DESC, "publishedDate"));
			blog.setItems(items);
		}
		user.setBlogs(blogs);
		return user;
	}

	public void save(User user) {
		// TODO Auto-generated method stub
		user.setEnabled(true);
		BCryptPasswordEncoder encoder  = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleRepository.findByName("ROLE_USER"));
		user.setRoles(roles);	
		
		userRepository.save(user);
		
	}

	public Object findOneWithBlogs(String name) {
		User user = userRepository.findByName(name);
		return findOneWithBlogs(user.getId());
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		userRepository.delete(id);
		
	}

	public User findOne(String username) {
		return userRepository.findByName(username);
	}

}
