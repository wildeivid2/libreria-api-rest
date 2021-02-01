package com.credibanco.assessment.library.dto;

import java.io.Serializable;
import java.util.Date;
import com.credibanco.assessment.library.model.Autor;
import com.credibanco.assessment.library.model.Editorial;

public class LibroDTO implements Serializable{
	
	private Integer id;
	private String titulo;
	private Date year;
	private String genero;
	private Integer numeroPaginas;
	private Editorial editorial;
	private Autor autor;
	
	private static final long serialVersionUID = 1L;

	
	public LibroDTO() {
		super();
	}


	public LibroDTO(Integer id, String titulo, Date year, String genero, Integer numeroPaginas, Editorial editorial, Autor autor) {
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
