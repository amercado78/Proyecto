package com.mx.jmi.adminJMI.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "subcategorias")
public class Subcategorias {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pksubcategoria;
	@Column
	private String nombre;
	@Column
	private String descripcion;
	@Column
	private String imagen;
	@OneToOne
    @JoinColumn(name = "fkcategoria", referencedColumnName = "pkcategoria", updatable = false, nullable = false)
	private Categorias categoria;
	@Column
	private Integer estatus;
	@Column
	private String uc;
	@Column
	private Timestamp fc;
	@Column
	private String ua;
	@Column
	private Timestamp fa;
	
	
	
	public Integer getPksubcategoria() {
		return pksubcategoria;
	}
	public void setPksubcategoria(Integer pksubcategoria) {
		this.pksubcategoria = pksubcategoria;
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
	public Categorias getCategoria() {
		return categoria;
	}
	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}
	public Integer getEstatus() {
		return estatus;
	}
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}
	public String getUc() {
		return uc;
	}
	public void setUc(String uc) {
		this.uc = uc;
	}
	public Timestamp getFc() {
		return fc;
	}
	public void setFc(Timestamp fc) {
		this.fc = fc;
	}
	public String getUa() {
		return ua;
	}
	public void setUa(String ua) {
		this.ua = ua;
	}
	public Timestamp getFa() {
		return fa;
	}
	public void setFa(Timestamp fa) {
		this.fa = fa;
	}
}
