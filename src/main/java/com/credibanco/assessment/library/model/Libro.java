package com.credibanco.assessment.library.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "libros", uniqueConstraints = {@UniqueConstraint(columnNames = "titulo")})
@SequenceGenerator(name="SeqLibros", sequenceName = "SEQ_LIBROS", initialValue = 1,  allocationSize = 1)
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqLibros")
	private Integer id;
	
	@NotBlank
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 50)
	private String titulo;
	
	@Nullable
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy")
	@Past
	private Date year;
	
	@NotBlank
	@Size(max = 20)
	private String genero;
	
	
	@NotNull
	@Min(1)
	private Integer numeroPaginas;
	
	@OneToOne
	@JoinColumn(name = "editorial_id")
	private Editorial editorial;
	
	@OneToOne
	@JoinColumn(name = "autor_id")
	private Autor autor;

	
	public Libro() {
		
	}


	public Libro(Integer id, @NotBlank @NotNull @NotEmpty @Size(min = 3, max = 50) String titulo, @Null @Past Date year,
			@NotBlank @Size(max = 20) String genero, @NotNull @Size(min = 1) Integer numeroPaginas, Editorial editorial,
			Autor autor) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.year = year;
		this.genero = genero;
		this.numeroPaginas = numeroPaginas;
		this.editorial = editorial;
		this.autor = autor;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public Date getYear() {
		return year;
	}


	public void setYear(Date year) {
		this.year = year;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}


	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}


	public Editorial getEditorial() {
		return editorial;
	}


	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}


	public Autor getAutor() {
		return autor;
	}


	public void setAutor(Autor autor) {
		this.autor = autor;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Libro [id=");
		builder.append(id);
		builder.append(", titulo=");
		builder.append(titulo);
		builder.append(", year=");
		builder.append(year);
		builder.append(", genero=");
		builder.append(genero);
		builder.append(", numeroPaginas=");
		builder.append(numeroPaginas);
		builder.append(", editorial=");
		builder.append(editorial);
		builder.append(", autor=");
		builder.append(autor);
		builder.append("]");
		return builder.toString();
	}

	
}
