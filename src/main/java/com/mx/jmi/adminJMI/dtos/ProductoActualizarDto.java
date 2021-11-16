package com.mx.jmi.adminJMI.dtos;

import java.util.Map;

public class ProductoActualizarDto {
	private int id;
	private String nombreProducto;
	private String descripcionProducto;
	private float precio;
	private int precioProductoId;
	private int estatusId;
	private Map<Integer, String> subcategorias;
	private Map<Integer, String> categorias;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getDescripcionProducto() {
		return descripcionProducto;
	}
	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getEstatusId() {
		return estatusId;
	}
	public void setEstatusId(int estatusId) {
		this.estatusId = estatusId;
	}
	public Map<Integer, String> getCategorias() {
		return categorias;
	}
	public void setCategorias(Map<Integer, String> categorias) {
		this.categorias = categorias;
	}
	public int getPrecioProductoId() {
		return precioProductoId;
	}
	public void setPrecioProductoId(int precioProductoId) {
		this.precioProductoId = precioProductoId;
	}
	public Map<Integer, String> getSubcategorias() {
		return subcategorias;
	}
	public void setSubcategorias(Map<Integer, String> subcategorias) {
		this.subcategorias = subcategorias;
	}
}
