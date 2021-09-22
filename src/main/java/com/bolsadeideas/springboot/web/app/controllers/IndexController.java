package com.bolsadeideas.springboot.web.app.controllers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bolsadeideas.springboot.web.app.models.usuario;


@Controller
@RequestMapping("/app")



public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	@Value("${texto.indexcontroller.listarperfil.titulo}")
	private String textoparrafo;
	
  @GetMapping({"/index", "/", "/home"})
	public String index(Model model) {
		model.addAttribute("titulo", textoIndex);
		model.addAttribute("parrafo", textoparrafo);
	
		return "index";
		
	}
	@RequestMapping("/perfil")
	public String perfil (Model model) {
		usuario usuario=new usuario(); 
		usuario.setNombre("Andres ");
		usuario.setApellido("rodriguez");
		usuario.setEmail("andre123@gmail.com");
		model.addAttribute("usuario",usuario);
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
		return "perfil";	
		
	}
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", textoListar);
		return "listar";
		
		
	}
	@ModelAttribute("usuarios")
	public List<usuario> poblarusuarios(){
		List<usuario> usuarios= Arrays.asList(new usuario("Andres", "guzman","andres123@gmail.com"),
				new usuario("alejando", "rodriguez","alejandro123@gmail.com"),
				new usuario("Antonio", "mendez","antonio123@gmail.com")); 
		return usuarios;
	}
	
}
