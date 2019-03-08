package br.com.encurtadorurl.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.encurtadorurl.entity.DadosUrl;
import br.com.encurtadorurl.service.EncurtadorUrlService;

@RestController
public class encurtarController {
	
	@Autowired
	private EncurtadorUrlService encurtadorUrlService;
	
	
	//TODO: Trocar para post
	@GetMapping("/encurtarUrl")
	private String encurtarUrl(HttpServletRequest request) {
		DadosUrl a = encurtadorUrlService.encurtarESalvar("http://globo.com/", request);
		
		return a.getUrlEncurtada();
	}
	
}
