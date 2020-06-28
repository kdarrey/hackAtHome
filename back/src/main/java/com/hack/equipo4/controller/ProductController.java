package com.hack.equipo4.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hack.equipo4.dtos.Product;
import com.hack.equipo4.repository.ProductRespository;
import com.hack.equipo4.utils.Utils;

@Controller
public class ProductController {
	
	private ProductRespository productRespository;
	
	@GetMapping(path="/allProductos",produces=MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins="*")// in this line add your url and thats is all for spring boot side
	@ResponseStatus( HttpStatus.OK )
	public List<Product> findAllProductos(){
		//List<Product> products = new ArrayList<Product>();
		//products = (List<Product>) this.productRespository.findAll();
		Utils utils = new Utils();
		return utils.generateProduct();
		
	}

}
