package com.credibanco.assessment.library.controller;

import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.library.dto.LibroDTO;
import com.credibanco.assessment.library.exceptions.LibroException;
import com.credibanco.assessment.library.model.Libro;
import com.credibanco.assessment.library.service.ILibroService;

@RestController
@CrossOrigin({"*"})
@RequestMapping(value = "/api/libros")
public class LibrosRestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LibrosRestController.class);
	
	@Autowired
	private ILibroService iLibroService;
	
	
	@GetMapping("/listar-libros")
	public Collection<LibroDTO> listarLibros(){
		return this.iLibroService.listarLibros();
	}
	
	@GetMapping("/listar-libros-autor/{id}")
	public Collection<LibroDTO> listarLibrosPorAutor(@PathVariable Integer id){
		return this.iLibroService.consultarLibrosPorIdAutor(id);
	}
	
	@GetMapping("/listar-libros-editorial/{id}")
	public Collection<LibroDTO> listarLibrosPorEditorial(@PathVariable Integer id){
		return this.iLibroService.consultarLibrosPorIdEditorial(id);
	}
	
	@GetMapping("/consultar-libro/{id}")
	public LibroDTO consultarLibroPorId(@PathVariable Integer id) {
		LibroDTO libroDTO = null;
		
		try {
			libroDTO = this.iLibroService.consultarLibroPorId(id);
		} catch (LibroException e) {
			LOGGER.error("[ERROR] [Error consultado el Libro - El libro no existe] LibrosRestController.consultarLibroPorId(Integer id)".concat(e.getStackTrace().toString()));
		}
		
		return libroDTO;
	}
	
	@PutMapping("/guardar-libro")
	public ResponseEntity<LibroDTO> guardarLibro(@RequestBody Libro libro) {
		LibroDTO libroDTO = this.iLibroService.guardarLibro(libro);
		
		return new ResponseEntity<LibroDTO>(libroDTO, HttpStatus.CREATED);
	}
	
	@PostMapping("/actualizar-libro")
	public ResponseEntity<LibroDTO> actualizarLibro(@RequestBody Libro libro) {
		LibroDTO libroDTO = this.iLibroService.guardarLibro(libro);
		
		return new ResponseEntity<LibroDTO>(libroDTO, HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar-libro/{id}")
	public ResponseEntity<LibroDTO> eliminarLibro(@PathVariable Integer id) {
		LibroDTO libroDTO = null;
		
		try {
			libroDTO = this.iLibroService.consultarLibroPorId(id);
			this.iLibroService.eliminarLibro(id);
		} catch (LibroException e) {
			LOGGER.error("[ERROR] [Error eliminando el Libro - El libro no existe] LibrosRestController.eliminarLibro(Integer id)".concat(e.getMessage()));
			return new ResponseEntity<LibroDTO>(libroDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<LibroDTO>(libroDTO, HttpStatus.OK);
	}
	
}
