package br.com.encurtadorurl.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import br.com.encurtadorurl.service.EncurtadorUrlService;

@RestController
@RequestMapping(value="/redir")
public class redirecionarController {
	@Autowired
	private EncurtadorUrlService encurtadorUrlService;
	
	@GetMapping("/{urlCode}")
	public RedirectView redirecionar(@PathVariable String urlCode) {
		return new RedirectView (encurtadorUrlService.getByUrlCode(urlCode));
	}
}
