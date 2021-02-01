package com.credibanco.assessment.library.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.library.dao.IEditorialDAO;
import com.credibanco.assessment.library.dto.AutorDTO;
import com.credibanco.assessment.library.dto.EditorialDTO;
import com.credibanco.assessment.library.model.Autor;
import com.credibanco.assessment.library.model.Editorial;
import com.credibanco.assessment.library.service.IEditorialService;

@Service
public class EditorialServiceImpl implements IEditorialService {

	@Autowired
	private IEditorialDAO iEditorialDAO;
	

	@Override
	public Collection<EditorialDTO> listarEditoriales() {
		Collection<Editorial> editoriales = (Collection<Editorial>) this.iEditorialDAO.findAll();
		Collection<EditorialDTO> editorialDTO = new ArrayList<>();;
		
		if(!editoriales.isEmpty()) {
			for(Editorial editorial : editoriales) {
				editorialDTO.add(this.construirEditorialDTO(editorial));
			}
		}
		
		return editorialDTO;
	}

	@Override
	public void eliminarEditorial(Integer id) {
		this.iEditorialDAO.deleteById(id);
	}

	@Override
	public void guardarEditorial(Editorial editorial) {
		if(null != editorial) {
			this.iEditorialDAO.save(editorial);
		}
	}

	@Override
	public EditorialDTO consultarEditorialPorId(Integer id) {
		Editorial editorial = this.iEditorialDAO.findById(id).orElseThrow();
		return this.construirEditorialDTO(editorial);
	}

	@Override
	public EditorialDTO consultarEditorial(Editorial editorial) {
		Editorial editorialConsultada = this.iEditorialDAO.findById(editorial.getId()).orElseThrow();
		return this.construirEditorialDTO(editorialConsultada);
	}

	@Override
	public EditorialDTO consultarEditorialPorCorreoElectronico(String correoElectronico) {
		Editorial editorialConsultada = this.iEditorialDAO.findByCorreoElectronico(correoElectronico).orElseThrow();
		return this.construirEditorialDTO(editorialConsultada);
	}

	private EditorialDTO construirEditorialDTO(Editorial editorial) {
		EditorialDTO editorialDTO = new EditorialDTO();
		
		editorialDTO.setId(editorial.getId());
		editorialDTO.setNombre(editorial.getNombre());
		editorialDTO.setTelefono(editorial.getTelefono());
		editorialDTO.setMaximoLibrosRegistrar(editorial.getMaximoLibrosRegistrar());
		editorialDTO.setDireccionCorrespondencia(editorial.getDireccionCorrespondencia());
		editorialDTO.setCorreoElectronico(editorial.getCorreoElectronico());
		
		return editorialDTO;
	}

}
