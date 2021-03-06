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

import com.hack.equipo4.dtos.Oferta;
import com.hack.equipo4.repository.OfertaRepository;
import com.hack.equipo4.utils.Utils;

@Controller
public class OfertasController {
	
	@Autowired
	private OfertaRepository productRespository;
	
	@GetMapping(path="/allOfertas",produces=MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins="*")// in this line add your url and thats is all for spring boot side
	@ResponseStatus( HttpStatus.OK )
	public @ResponseBody List<Oferta> findAllProductos(){
		//List<Product> products = new ArrayList<Product>();
		//products = (List<Product>) this.productRespository.findAll();
		Utils utils = new Utils();
		return utils.generateOfertas();
		
	}

}
