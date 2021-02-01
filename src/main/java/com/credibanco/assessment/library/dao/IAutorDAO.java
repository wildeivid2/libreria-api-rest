package com.credibanco.assessment.library.dao;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.credibanco.assessment.library.model.Autor;

public interface IAutorDAO extends CrudRepository<Autor, Integer> {

	public Optional<Autor> findByCorreoElectronico(String correoElectronico);
	
}
