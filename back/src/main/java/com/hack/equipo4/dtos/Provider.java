package com.hack.equipo4.dtos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Provider {
	
	@Id
	private Integer id;
	private String nombre;
	private String CIF;
	private String mail;
	private String direccion;
	private String telefono;
	private List<Product> productos;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCIF() {
		return CIF;
	}
	public void setCIF(String cIF) {
		CIF = cIF;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public List<Product> getProductos() {
		return productos;
	}
	public void setProductos(List<Product> productos) {
		this.productos = productos;
	}
	

}
