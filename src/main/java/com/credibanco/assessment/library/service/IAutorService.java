package com.credibanco.assessment.library.service;

import java.util.Collection;
import com.credibanco.assessment.library.dto.AutorDTO;
import com.credibanco.assessment.library.model.Autor;

public interface IAutorService {
	
	public Collection<AutorDTO> listarAutores();
	
	public void eliminarAutor(Integer id);
	
	public void guardarAutor(Autor autor);
	
	public AutorDTO consultarAutorPorId(Integer id);
	
	public AutorDTO consultarAutor(Autor autor);
	
	public AutorDTO consultarAutorPorCorreoElectronico(String correoElectronico);
	
}
