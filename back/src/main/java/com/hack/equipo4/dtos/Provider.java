package com.hack.equipo4.dtos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Provider {
	
	@Id
	private Integer idProvider;
	private String nombre;
	private String CIF;
	private String mail;
	private String direccion;
	private String telefono;
	@OneToMany(targetEntity=Oferta.class, mappedBy="provider", fetch=FetchType.EAGER)

	private List<Oferta> productos;
	
	
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
	public List<Oferta> getProductos() {
		return productos;
	}
	public void setProductos(List<Oferta> productos) {
		this.productos = productos;
	}
	public Integer getIdProvider() {
		return idProvider;
	}
	public void setIdProvider(Integer idProvider) {
		this.idProvider = idProvider;
	}
	

}
