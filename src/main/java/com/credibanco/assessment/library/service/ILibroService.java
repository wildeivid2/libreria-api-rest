package com.credibanco.assessment.library.service;

import java.util.Collection;
import com.credibanco.assessment.library.dto.LibroDTO;
import com.credibanco.assessment.library.exceptions.LibroException;
import com.credibanco.assessment.library.model.Libro;

public interface ILibroService {
	
	public Collection<LibroDTO> listarLibros();
	
	public void eliminarLibro(Integer id);
	
	public LibroDTO guardarLibro(Libro libro);
	
	public LibroDTO consultarLibroPorId(Integer id) throws LibroException;
	
	public LibroDTO consultarLibro(Libro libro) throws LibroException;
	
	public Collection<LibroDTO> consultarLibrosPorIdEditorial(Integer id);
	
	public Collection<LibroDTO> consultarLibrosPorIdAutor(Integer id);
	
}
