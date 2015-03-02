package com.egroeg.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egroeg.jba.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
