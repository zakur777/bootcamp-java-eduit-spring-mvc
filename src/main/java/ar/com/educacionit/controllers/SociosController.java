package ar.com.educacionit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ar.com.educacionit.domain.Socios;
import ar.com.educacionit.services.SociosService;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/socio")
public class SociosController {

	//D.I
    @Autowired
    private SociosService sociosService;

	//http://localhost:8081/socio/all
    @GetMapping("/all")
	public String all(Model model) {
		List<Socios> socios = this.sociosService.buscarTodos();
		model.addAttribute("socios", socios);
		return "socios";
    }
	
	@GetMapping("/delete") 
	public String delete(
			@RequestParam(name="idSocio",required = true ) Long idSocios
			) {
		
		this.sociosService.eliminar(idSocios);
		
		return "redirect:/socio/all";
	}
	
	@GetMapping("/edit/{id}") 
	public String preEdit(
			@PathVariable(name="id",required = true ) Long id,
			Model model
			) {
		
		Socios socios = this.sociosService.buscarSocio(id);
		
		model.addAttribute("SOCIO",socios);
		
		return "edit";
	}

	@PostMapping("/edit")
	public ModelAndView editar() {
		ModelAndView modelAndView = new ModelAndView("/socio/all");
		return modelAndView;
	}
	
}
