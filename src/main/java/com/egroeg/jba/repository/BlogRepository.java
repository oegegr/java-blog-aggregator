package com.egroeg.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egroeg.jba.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer>{

}
