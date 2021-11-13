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
@Table(name = "productos_imagenes")
public class ProductosImagenes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pkproductoimagen;
	@Column
	private String url;
	@OneToOne
    @JoinColumn(name = "fkproducto", referencedColumnName = "pkproducto", updatable = false, nullable = false)
	private Productos productos;
	@Column
	private Integer estatus;
	@Column
	private String ac;
	@Column
	private Timestamp fc;
	@Column
	private String ua;
	@Column
	private Timestamp fa;
	public Integer getPkproductoimagen() {
		return pkproductoimagen;
	}
	public void setPkproductoimagen(Integer pkproductoimagen) {
		this.pkproductoimagen = pkproductoimagen;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Productos getProductos() {
		return productos;
	}
	public void setProductos(Productos productos) {
		this.productos = productos;
	}
	public Integer getEstatus() {
		return estatus;
	}
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}
	public String getAc() {
		return ac;
	}
	public void setAc(String ac) {
		this.ac = ac;
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
