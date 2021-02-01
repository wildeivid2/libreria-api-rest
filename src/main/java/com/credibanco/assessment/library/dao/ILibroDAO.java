package com.credibanco.assessment.library.dao;

import java.util.Collection;
import org.springframework.data.repository.CrudRepository;
import com.credibanco.assessment.library.model.Autor;
import com.credibanco.assessment.library.model.Editorial;
import com.credibanco.assessment.library.model.Libro;

public interface ILibroDAO extends CrudRepository<Libro, Integer> {
	
	Collection<Libro> findByEditorial(Editorial editorial);
	
	Collection<Libro> findByAutor(Autor autor);
	
}
