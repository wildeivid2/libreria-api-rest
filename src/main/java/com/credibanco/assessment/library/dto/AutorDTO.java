package com.credibanco.assessment.library.dto;

import java.io.Serializable;
import java.util.Date;

public class AutorDTO implements Serializable{
	
	private Integer id;
	private String nombreCompleto;
	private Date fechaNacimiento;
	private String ciudadProcedencia;
	private String correoElectronico;
	
	private static final long serialVersionUID = 1L;

	
	public AutorDTO() {
		
	}

	public AutorDTO(Integer id, String nombreCompleto, Date fechaNacimiento,String ciudadProcedencia, String correoElectronico) {
		super();
		this.id = id;
		this.nombreCompleto = nombreCompleto;
		this.fechaNacimiento = fechaNacimiento;
		this.ciudadProcedencia = ciudadProcedencia;
		this.correoElectronico = correoElectronico;
	}
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCiudadProcedencia() {
		return ciudadProcedencia;
	}

	public void setCiudadProcedencia(String ciudadProcedencia) {
		this.ciudadProcedencia = ciudadProcedencia;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	
	@Override
	public String toString() {
		return "Autor [id=".concat(id.toString()).concat(", nombreCompleto=").concat(nombreCompleto).concat(", fechaNacimiento=").concat(fechaNacimiento.toString())
				.concat(", ciudadProcedencia=").concat(ciudadProcedencia).concat(", correoElectronico=").concat(correoElectronico).concat("]");
	}
	
}
