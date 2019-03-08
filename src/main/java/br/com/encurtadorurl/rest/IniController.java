package br.com.encurtadorurl.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IniController {
	
	@RequestMapping(value = "/")
	private String index() {
		return "index";
	}
}
