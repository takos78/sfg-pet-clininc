package guru.springframework.sfgpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

	@RequestMapping({"", "/", "index.html"})
	public String start() {
		return "index";
	}

	@RequestMapping({"oups"})
	public String error() {
		return "notimplemented";
	}	
	
}
