package com.credibanco.assessment.library.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "autores", uniqueConstraints = {@UniqueConstraint(columnNames = "correo_electronico")})
@SequenceGenerator(name="SeqAutores", sequenceName = "SEQ_AUTORES", initialValue = 1,  allocationSize = 1)
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqAutores")
	private Integer id;
	
	@NotBlank
	@NotNull
	@NotEmpty
	@Size(min = 5, max = 100)
	private String nombreCompleto;
	
	@Null
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Past
	private Date fechaNacimiento;
	
	@Size(max = 50)
	private String ciudadProcedencia;
	
	@Null
	@Size(max = 50)
	@Email
	@Column(name = "correo_electronico")
	private String correoElectronico;

	
	public Autor() {
		
	}

	public Autor(Integer id, @NotBlank @NotNull @NotEmpty @Size(min = 5, max = 100) String nombreCompleto,
			@Null @Past Date fechaNacimiento, @Size(max = 50) String ciudadProcedencia,
			@Size(max = 50) @Email String correoElectronico) {
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
