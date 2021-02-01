package com.credibanco.assessment.library.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.library.dao.IAutorDAO;
import com.credibanco.assessment.library.dao.IEditorialDAO;
import com.credibanco.assessment.library.dao.ILibroDAO;
import com.credibanco.assessment.library.dto.LibroDTO;
import com.credibanco.assessment.library.exceptions.LibroException;
import com.credibanco.assessment.library.model.Autor;
import com.credibanco.assessment.library.model.Editorial;
import com.credibanco.assessment.library.model.Libro;
import com.credibanco.assessment.library.service.ILibroService;
import com.credibanco.assessment.library.types.MensajesLibrosException;

@Service
public class LibroServiceImpl implements ILibroService {
	
	@Autowired
	private ILibroDAO iLibroDAO;
	
	@Autowired 
	IAutorDAO iAutorDAO;
	
	@Autowired
	IEditorialDAO iEditorialDAO;
	
	
	@Override
	public Collection<LibroDTO> listarLibros() {
		Collection<Libro> libros = (Collection<Libro>) this.iLibroDAO.findAll();
		Collection<LibroDTO> libroDTO = new ArrayList<>();
		
		if(!libros.isEmpty()) {
			for (Libro libro : libros) {
				libroDTO.add(this.construirLibroDTO(libro));
			}
		}
		
		return libroDTO;
	}

	@Override
	public void eliminarLibro(Integer id) {
		this.iLibroDAO.deleteById(id);
	}

	@Override
	public LibroDTO guardarLibro(Libro libro) {
		Libro libroGuardado = null;
		
		if(null != libro) {
			libroGuardado = this.iLibroDAO.save(libro);
		}
		
		return this.construirLibroDTO(libroGuardado);
	}

	@Override
	public LibroDTO consultarLibroPorId(Integer id) throws LibroException {
		Libro libro = this.iLibroDAO.findById(id).orElseThrow(() -> new LibroException(MensajesLibrosException.LIBRO_NO_EXISTE.getMensaje()));
		return this.construirLibroDTO(libro);
	}

	@Override
	public LibroDTO consultarLibro(Libro libro) throws LibroException {
		Libro libroConsultado = this.iLibroDAO.findById(libro.getId()).orElseThrow(() -> new LibroException(MensajesLibrosException.LIBRO_NO_EXISTE.getMensaje()));
		return this.construirLibroDTO(libroConsultado);
	}

	@Override
	public Collection<LibroDTO> consultarLibrosPorIdEditorial(Integer id) {
		Collection<LibroDTO> librosPorEditorial = new ArrayList<>();
		boolean isExisteEditorial = this.iEditorialDAO.existsById(id);
		
		if(isExisteEditorial) {
			Editorial editorial = new Editorial();
			editorial.setId(id);
			
			for(Libro libro : this.iLibroDAO.findByEditorial(editorial)) {
				librosPorEditorial.add(this.construirLibroDTO(libro));
			}
		}
		
		return librosPorEditorial;
	}

	@Override
	public Collection<LibroDTO> consultarLibrosPorIdAutor(Integer id) {
		Collection<LibroDTO> librosPorAutor = new ArrayList<>();
		boolean isExisteAutor = this.iAutorDAO.existsById(id);
		
		if(isExisteAutor) {
			Autor autor = new Autor();
			autor.setId(id);
			
			for(Libro libro : this.iLibroDAO.findByAutor(autor)) {
				librosPorAutor.add(this.construirLibroDTO(libro));
			}
		}
		
		return librosPorAutor;
	}
	
	private LibroDTO construirLibroDTO(Libro libro) {
		LibroDTO libroDTO = new LibroDTO();
		
		libroDTO.setId(libro.getId());
		libroDTO.setTitulo(libro.getTitulo());
		libroDTO.setYear(libro.getYear());
		libroDTO.setNumeroPaginas(libro.getNumeroPaginas());
		libroDTO.setGenero(libro.getGenero());
		libroDTO.setAutor(libro.getAutor());
		libroDTO.setEditorial(libro.getEditorial());
		
		return libroDTO;
	}
	
}
