package com.hack.equipo4.utils;

import java.util.ArrayList;
import java.util.List;

import com.hack.equipo4.dtos.Oferta;
import com.hack.equipo4.dtos.Provider;

public class Utils {
	
	public List<Oferta> generateOfertas(){
		List<Oferta> productos = new ArrayList<>();
		Oferta p = new Oferta();
		p.setNombre("Patatas");
		p.setPrecio(12.0);
		
		productos.add(p);
		return productos;
			
	}

	public List<Provider> generateProviders(){
		List<Provider> providers = new ArrayList<>();
		Provider provider1 = new Provider();
		provider1.setNombre("Frutas Martinez");
		
		Provider provider2 = new Provider();
		provider2.setNombre("Verduras María");
		
		providers.add(provider1);
		providers.add(provider2);
		
		return providers;
	}
}
