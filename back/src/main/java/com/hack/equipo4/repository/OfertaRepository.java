package com.hack.equipo4.repository;

import org.springframework.data.repository.CrudRepository;

import com.hack.equipo4.dtos.Oferta;
import com.hack.equipo4.dtos.User;

public interface OfertaRepository extends CrudRepository<Oferta, Integer> {

	User findByNombre(String nombre);
	

}
