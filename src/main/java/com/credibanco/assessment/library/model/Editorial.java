package com.credibanco.assessment.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "editoriales", uniqueConstraints = {@UniqueConstraint(columnNames = "correo_electronico")})
@SequenceGenerator(name="SeqEditoriales", sequenceName = "SEQ_EDITORIALES", initialValue = 1,  allocationSize = 1)
public class Editorial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqEditoriales")
	private Integer id;
	
	@NotBlank
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 50)
	private String nombre;
	
	@NotBlank
	@Size(max = 100)
	private String direccionCorrespondencia;
	
	@NotBlank
	@Size(max = 11)
	private String telefono;
	
	@Size(max = 50)
	@Email
	@Column(name = "correo_electronico")
	private String correoElectronico;
	
	@NotNull
	@Min(-1)
	private Integer maximoLibrosRegistrar;

	
	public Editorial() {
		super();
	}

	public Editorial(Integer id, @NotBlank @NotNull @NotEmpty @Size(min = 3, max = 50) String nombre,
			@NotBlank @Size(max = 100) String direccionCorrespondencia, @NotBlank @Size(max = 11) String telefono,
			@Size(max = 50) @Email String correoElectronico,
			@NotNull @Size(min = -1, max = 9999) Integer maximoLibrosRegistrar) {
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
