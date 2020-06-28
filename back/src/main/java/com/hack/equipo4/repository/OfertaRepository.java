package com.hack.equipo4.repository;

import org.springframework.data.repository.CrudRepository;

import com.hack.equipo4.dtos.Product;
import com.hack.equipo4.dtos.User;

public interface ProductRespository extends CrudRepository<Product, Integer> {

	User findByNombre(String nombre);
	

}
