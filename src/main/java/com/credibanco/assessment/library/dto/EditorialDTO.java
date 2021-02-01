package com.credibanco.assessment.library.dto;

import java.io.Serializable;

public class EditorialDTO implements Serializable{
	
	private Integer id;
	private String nombre;
	private String direccionCorrespondencia;
	private String telefono;
	private String correoElectronico;
	private Integer maximoLibrosRegistrar;
	
	private static final long serialVersionUID = 1L;

	
	public EditorialDTO() {
		super();
	}

	public EditorialDTO(Integer id, String nombre, String direccionCorrespondencia, String telefono, String correoElectronico, Integer maximoLibrosRegistrar) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccionCorrespondencia = direccionCorrespondencia;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
		this.maximoLibrosRegistrar = maximoLibrosRegistrar;
	}

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

	public String getDireccionCorrespondencia() {
		return direccionCorrespondencia;
	}

	public void setDireccionCorrespondencia(String direccionCorrespondencia) {
		this.direccionCorrespondencia = direccionCorrespondencia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public Integer getMaximoLibrosRegistrar() {
		return maximoLibrosRegistrar;
	}

	public void setMaximoLibrosRegistrar(Integer maximoLibrosRegistrar) {
		this.maximoLibrosRegistrar = maximoLibrosRegistrar;
	}

	@Override
	public String toString() {
		return "Editorial [id=".concat(id.toString()).concat(", nombre=").concat(nombre).concat(", direccionCorrespondencia=").concat(direccionCorrespondencia)
				.concat(", telefono=").concat(telefono).concat(", correoElectronico=").concat(correoElectronico).concat(", maximoLibrosRegistrar=").concat(maximoLibrosRegistrar.toString()).concat("]");
	}
	
}
