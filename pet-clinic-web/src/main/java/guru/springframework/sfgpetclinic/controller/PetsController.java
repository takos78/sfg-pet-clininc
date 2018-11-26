package guru.springframework.sfgpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pets")
public class PetsController {

	@RequestMapping(value = {"", "/", "index.html"})
	public String start(Model model) {
		return "pet/index.html";
	}
	
}
