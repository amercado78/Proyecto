package com.mx.jmi.adminJMI.dtos;

public class ProductoDto {
	private int id;
	private String nombre;
	private String descripcion;
	private int precioProductoId; 
	private float precioMenudeo;
	private float precioMayoreo;
	private int subcategoriaId;
	private String subcategoria;
	private int categoriaId;
	private String categoria;
	private int estatusId;
	private String estatus;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getPrecioProductoId() {
		return precioProductoId;
	}
	public void setPrecioProductoId(int precioProductoId) {
		this.precioProductoId = precioProductoId;
	}
	public float getPrecioMenudeo() {
		return precioMenudeo;
	}
	public void setPrecioMenudeo(float precioMenudeo) {
		this.precioMenudeo = precioMenudeo;
	}
	public float getPrecioMayoreo() {
		return precioMayoreo;
	}
	public void setPrecioMayoreo(float precioMayoreo) {
		this.precioMayoreo = precioMayoreo;
	}
	public int getSubcategoriaId() {
		return subcategoriaId;
	}
	public void setSubcategoriaId(int subcategoriaId) {
		this.subcategoriaId = subcategoriaId;
	}
	public String getSubcategoria() {
		return subcategoria;
	}
	public void setSubcategoria(String subcategoria) {
		this.subcategoria = subcategoria;
	}
	public int getCategoriaId() {
		return categoriaId;
	}
	public void setCategoriaId(int categoriaId) {
		this.categoriaId = categoriaId;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getEstatusId() {
		return estatusId;
	}
	public void setEstatusId(int estatusId) {
		this.estatusId = estatusId;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
}
