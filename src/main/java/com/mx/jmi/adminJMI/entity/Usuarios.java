package com.mx.jmi.adminJMI.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuarios {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pkusuario;
	@Column
	private String nombres;
	@Column
	private String apellidos;
	@Column
	private String correo;
	@Column
	private String contrasena;
	@Column
	private Integer estatus;	
	@OneToOne
	//@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	//@OneToMany(cascade = CascadeType.ALL)
	//@ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fkrol", referencedColumnName = "pkRol", updatable = false, nullable = false)
	private Roles rol;
	
	
	public Roles getRol() {
		return rol;
	}
	public void setRol(Roles rol) {
		this.rol = rol;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public Long getPkusuario() {
		return pkusuario;
	}
	public void setPkusuario(Long pkusuario) {
		this.pkusuario = pkusuario;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Integer getEstatus() {
		return estatus;
	}
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}
}
