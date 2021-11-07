package com.mx.jmi.adminJMI.entity;

import java.util.*;
import javax.persistence.*;


@Entity
@Table(name = "usuarios")
public class Usuarios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pkusuario;
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
	//@OneToOne
	//@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	//@OneToMany(cascade = CascadeType.ALL)
	//@ManyToMany(cascade = CascadeType.ALL)
    //--@JoinColumn(name = "fkrol", referencedColumnName = "pkRol", updatable = false, nullable = false)
	/*private Roles rol;
	
	
	public Roles getRol() {
		return rol;
	}
	public void setRol(Roles rol) {
		this.rol = rol;
	}*/
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "usuarios_pkusuario"),
            inverseJoinColumns = @JoinColumn(name = "roles_pkrol")
            )
	private Set<Roles> roles = new HashSet<>();
    	
	public Set<Roles> getRoles() {
		return roles;
	}
	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public Integer getPkusuario() {
		return pkusuario;
	}
	public void setPkusuario(Integer pkusuario) {
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
