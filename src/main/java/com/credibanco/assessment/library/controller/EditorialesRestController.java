package com.credibanco.assessment.library.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.library.dto.EditorialDTO;
import com.credibanco.assessment.library.service.IEditorialService;

@RestController
@CrossOrigin({"*"})
@RequestMapping(value = "/api/editoriales")
public class EditorialesRestController {
	
	//private static final Logger LOGGER = LoggerFactory.getLogger(EditorialesRestController.class);
	
	@Autowired
	private IEditorialService iEditorialService;
	
	
	@GetMapping("/listar-editoriales")
	public Collection<EditorialDTO> listarEditoriales(){
		return this.iEditorialService.listarEditoriales();
	}
	
}
