package com.prueba.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String correoelectronico;
	private String contraseña;
	private String nombre_completo;
	private Date ultima_conexion;
	private Date fecha_registro;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCorreoelectronico() {
		return correoelectronico;
	}
	public void setCorreo_electronico(String correoelectronico) {
		this.correoelectronico = correoelectronico;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getNombre_completo() {
		return nombre_completo;
	}
	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}
	public Date getUltima_conexion() {
		return ultima_conexion;
	}
	public void setUltima_conexion(Date ultima_conexion) {
		this.ultima_conexion = ultima_conexion;
	}
	
	
	public Date getFecha_registro() {
		System.out.print(fecha_registro.toString().substring(0, 9));
		return fecha_registro;
	}
	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", correo_electronico=" + correoelectronico + ", contraseña=" + contraseña
				+ ", nombre_completo=" + nombre_completo + ", ultima_conexion=" + ultima_conexion + ", fecha_registro="
				+ fecha_registro + "]";
	}


	
}
