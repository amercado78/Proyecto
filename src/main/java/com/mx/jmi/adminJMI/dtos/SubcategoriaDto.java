package com.mx.jmi.adminJMI.dtos;

public class SubcategoriaDto {
	private Integer id;
	private String nombre;
	private String descripcion;
	private String imagen;
	private int idCategoriaPadre;
	private String descripcionCategoriaPadre;
	private Integer estatus;
	private String estatusDescripcion;
	
	
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public int getIdCategoriaPadre() {
		return idCategoriaPadre;
	}
	public void setIdCategoriaPadre(int idCategoriaPadre) {
		this.idCategoriaPadre = idCategoriaPadre;
	}
	public String getDescripcionCategoriaPadre() {
		return descripcionCategoriaPadre;
	}
	public void setDescripcionCategoriaPadre(String descripcionCategoriaPadre) {
		this.descripcionCategoriaPadre = descripcionCategoriaPadre;
	}
	public Integer getEstatus() {
		return estatus;
	}
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}
	public String getEstatusDescripcion() {
		return estatusDescripcion;
	}
	public void setEstatusDescripcion(String estatusDescripcion) {
		this.estatusDescripcion = estatusDescripcion;
	}
}
