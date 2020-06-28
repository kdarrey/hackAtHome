package com.hack.equipo4.utils;

import java.util.ArrayList;
import java.util.List;

import com.hack.equipo4.dtos.Product;

public class Utils {
	
	public List<Product> generateProduct(){
		List<Product> productos = new ArrayList<>();
		Product p = new Product();
		p.setNombre("Patatas");
		p.setPrecio(12.0);
		
		productos.add(p);
		return productos;
			
	}

}
