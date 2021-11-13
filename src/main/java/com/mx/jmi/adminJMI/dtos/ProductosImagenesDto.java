package com.mx.jmi.adminJMI.dtos;

import java.util.List;

public class ProductosImagenesDto {
	private int id;
	private int idProducto;
	private String nombreProducto;
	private List<String> urlsImagenes;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public List<String> getUrlsImagenes() {
		return urlsImagenes;
	}
	public void setUrlsImagenes(List<String> urlsImagenes) {
		this.urlsImagenes = urlsImagenes;
	}
}
