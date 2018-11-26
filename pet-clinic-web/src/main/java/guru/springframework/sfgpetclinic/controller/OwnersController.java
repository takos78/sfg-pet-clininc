package guru.springframework.sfgpetclinic.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.service.OwnerService;

@Controller
@RequestMapping("/owners")
public class OwnersController {
	
	private final OwnerService ownerService;

	@Autowired
	public OwnersController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}



	@RequestMapping({"", "/", "index.html"})
	public String start(Model model) {
		
		Set<Owner> owners = ownerService.findAll();
		model.addAttribute("owners", owners);
		
		return "owners/index.html";
	}
	
}
