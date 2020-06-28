package com.hack.equipo4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hack.equipo4.dtos.Provider;
import com.hack.equipo4.repository.ProviderRepository;
import com.hack.equipo4.utils.Utils;
@Controller
public class ProviderController {
	
	@Autowired
	ProviderRepository providerRepository;

	
	@GetMapping(path="/allProviders",produces=MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins="*")// in this line add your url and thats is all for spring boot side
	@ResponseStatus( HttpStatus.OK )
	public @ResponseBody List<Provider> findAllProductos(){
		//List<Provider> products = new ArrayList<Provider>();
		//products = (List<Provider>) this.providerRepository.findAll();
		Utils utils = new Utils();
		return utils.generateProviders();
		
	}
}
