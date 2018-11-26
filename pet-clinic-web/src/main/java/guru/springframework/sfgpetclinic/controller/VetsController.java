package guru.springframework.sfgpetclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.sfgpetclinic.service.VetService;

@Controller
@RequestMapping("vets")
public class VetsController {

	private VetService vetService;
	
	@Autowired
	public VetsController(VetService vetService) {
		this.vetService = vetService;
	}



	@RequestMapping({"", "/", "index.html"})
	public String start(Model model) {
		model.addAttribute("vets", vetService.findAll());
		return "vet/index.html";
	}
	
}
