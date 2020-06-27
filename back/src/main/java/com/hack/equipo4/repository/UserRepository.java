package com.hack.equipo4.repository;

import org.springframework.data.repository.CrudRepository;

import com.hack.equipo4.dtos.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	User findByLogin(String login);
}
