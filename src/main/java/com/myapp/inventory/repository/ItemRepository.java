package com.myapp.inventory.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.inventory.entity.Item;

//access to JPA methods
@Repository
public interface ItemRepository extends JpaRepository<Item,Long>{

}