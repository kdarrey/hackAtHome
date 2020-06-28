package com.hack.equipo4.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hack.equipo4.dtos.User;
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	User findByLogin(String login);
}
