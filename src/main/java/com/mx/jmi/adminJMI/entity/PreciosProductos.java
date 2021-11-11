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
@Table(name = "precios_productos")
public class PreciosProductos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pkprecioproducto;
	@Column
	private Float preciomenudeo;
	@Column
	private Float preciomayoreo;
	@Column
	private Integer estatus;
	@OneToOne
    @JoinColumn(name = "fkproducto", referencedColumnName = "pkproducto", updatable = false, nullable = false)
	private Productos productos;
	@Column
	private String uc;
	@Column
	private Timestamp fc;
	@Column
	private String ua;
	@Column
	private Timestamp fa;
	public Integer getPkprecioproducto() {
		return pkprecioproducto;
	}
	public void setPkprecioproducto(Integer pkprecioproducto) {
		this.pkprecioproducto = pkprecioproducto;
	}
	public Float getPreciomenudeo() {
		return preciomenudeo;
	}
	public void setPreciomenudeo(Float preciomenudeo) {
		this.preciomenudeo = preciomenudeo;
	}
	public Float getPreciomayoreo() {
		return preciomayoreo;
	}
	public void setPreciomayoreo(Float preciomayoreo) {
		this.preciomayoreo = preciomayoreo;
	}
	public Integer getEstatus() {
		return estatus;
	}
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}
	public Productos getProductos() {
		return productos;
	}
	public void setProductos(Productos productos) {
		this.productos = productos;
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
