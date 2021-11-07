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
@Table(name = "productos")
public class Productos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pkproducto;
	@Column
	private Integer idaspelproducto;
	@Column
	private String nombre;
	@Column
	private String descripcion;
	@Column
	private String detalles;
	@Column
	private float largo;
	@Column
	private float ancho;
	@Column
	private float alto;
	@Column
	private float peso;
	@Column
	private Integer sugerido;
	@Column
	private Integer estatusproducto;
	@Column
	private Integer comprar;
	@OneToOne
    @JoinColumn(name = "fksubcategoria", referencedColumnName = "pksubcategoria", updatable = false, nullable = false)
	private Subcategorias subcategoria;
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
	public Integer getPkproducto() {
		return pkproducto;
	}
	public void setPkproducto(Integer pkproducto) {
		this.pkproducto = pkproducto;
	}
	public Integer getIdaspelproducto() {
		return idaspelproducto;
	}
	public void setIdaspelproducto(Integer idaspelproducto) {
		this.idaspelproducto = idaspelproducto;
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
	public String getDetalles() {
		return detalles;
	}
	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
	public float getLargo() {
		return largo;
	}
	public void setLargo(float largo) {
		this.largo = largo;
	}
	public float getAncho() {
		return ancho;
	}
	public void setAncho(float ancho) {
		this.ancho = ancho;
	}
	public float getAlto() {
		return alto;
	}
	public void setAlto(float alto) {
		this.alto = alto;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public Integer getSugerido() {
		return sugerido;
	}
	public void setSugerido(Integer sugerido) {
		this.sugerido = sugerido;
	}
	public Integer getEstatusproducto() {
		return estatusproducto;
	}
	public void setEstatusproducto(Integer estatusproducto) {
		this.estatusproducto = estatusproducto;
	}
	public Integer getComprar() {
		return comprar;
	}
	public void setComprar(Integer comprar) {
		this.comprar = comprar;
	}
	public Subcategorias getSubcategoria() {
		return subcategoria;
	}
	public void setSubcategoria(Subcategorias subcategoria) {
		this.subcategoria = subcategoria;
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
