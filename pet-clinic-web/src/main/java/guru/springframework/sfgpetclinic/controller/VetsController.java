package guru.springframework.sfgpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("vet")
public class VetsController {

	@RequestMapping({"", "/", "index.html"})
	public String start(Model model) {
		return "vet/index.html";
	}
	
}
