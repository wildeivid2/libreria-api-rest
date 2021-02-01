package com.credibanco.assessment.library.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.credibanco.assessment.library.dao.IAutorDAO;
import com.credibanco.assessment.library.dto.AutorDTO;
import com.credibanco.assessment.library.model.Autor;
import com.credibanco.assessment.library.service.IAutorService;

@Service
public class AutorServiceImpl implements IAutorService {
	
	@Autowired
	private IAutorDAO iAutorDAO;
	

	@Override
	public Collection<AutorDTO> listarAutores() {
		Collection<Autor> autores = (Collection<Autor>) this.iAutorDAO.findAll();
		Collection<AutorDTO> autoresDTO = new ArrayList<>();;
		
		if(!autores.isEmpty()) {
			for(Autor autor : autores) {
				autoresDTO.add(this.construirAutorDTO(autor));
			}
		}
		
		return autoresDTO;
	}

	@Override
	public void eliminarAutor(Integer id) {
		this.iAutorDAO.deleteById(id);

	}

	@Override
	public void guardarAutor(Autor autor) {
		if(null != autor) {
			this.iAutorDAO.save(autor);
		}
	}

	@Override
	public AutorDTO consultarAutorPorId(Integer id) {
		Autor autor = this.iAutorDAO.findById(id).orElseThrow();
		return this.construirAutorDTO(autor);
	}

	@Override
	public AutorDTO consultarAutor(Autor autor) {
		Autor autorConsultado = this.iAutorDAO.findById(autor.getId()).orElseThrow();
		return this.construirAutorDTO(autorConsultado);
	}

	@Override
	public AutorDTO consultarAutorPorCorreoElectronico(String correoElectronico) {
		Autor autorConsultado = this.iAutorDAO.findByCorreoElectronico(correoElectronico).orElseThrow();
		return this.construirAutorDTO(autorConsultado);
	}
	
	private AutorDTO construirAutorDTO(Autor autor) {
		AutorDTO autorDTO = new AutorDTO();
		
		autorDTO.setId(autor.getId());
		autorDTO.setNombreCompleto(autor.getNombreCompleto());
		autorDTO.setFechaNacimiento(autor.getFechaNacimiento());
		autorDTO.setCiudadProcedencia(autor.getCiudadProcedencia());
		autorDTO.setCorreoElectronico(autor.getCorreoElectronico());
		
		return autorDTO;
	}

}
