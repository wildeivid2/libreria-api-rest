package com.credibanco.assessment.library.service;

import java.util.Collection;
import com.credibanco.assessment.library.dto.EditorialDTO;
import com.credibanco.assessment.library.model.Editorial;

public interface IEditorialService {
	
	public Collection<EditorialDTO> listarEditoriales();
	
	public void eliminarEditorial(Integer id);
	
	public void guardarEditorial(Editorial editorial);
	
	public EditorialDTO consultarEditorialPorId(Integer id);
	
	public EditorialDTO consultarEditorial(Editorial editorial);
	
	public EditorialDTO consultarEditorialPorCorreoElectronico(String correoElectronico);
	
}
