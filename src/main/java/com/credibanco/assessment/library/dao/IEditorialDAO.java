package com.credibanco.assessment.library.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.credibanco.assessment.library.model.Editorial;

public interface IEditorialDAO extends CrudRepository<Editorial, Integer> {

	Optional<Editorial> findByCorreoElectronico(String correoElectronico);
	
}
