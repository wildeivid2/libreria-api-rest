package com.credibanco.assessment.library.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.credibanco.assessment.library.dto.AutorDTO;
import com.credibanco.assessment.library.service.IAutorService;

@RestController
@CrossOrigin({"*"})
@RequestMapping(value = "/api/autores")
public class AutoresRestController {
	
	//private static final Logger LOGGER = LoggerFactory.getLogger(EditorialesRestController.class);
	
	@Autowired
	private IAutorService iAutorService;
	
	
	@GetMapping("/listar-autores")
	public Collection<AutorDTO> listarEditoriales(){
		return this.iAutorService.listarAutores();
	}
	
}
