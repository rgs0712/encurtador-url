package br.com.encurtadorurl.rest;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import br.com.encurtadorurl.service.EncurtadorUrlService;

@RestController
@RequestMapping("/encurtarUrl")
public class encurtarController {
	
	@Autowired
	private EncurtadorUrlService encurtadorUrlService;
	
	@PostMapping("/encurtar")
	public ResponseEntity<Map<String, Object>> encurtarUrl(@RequestBody String url, HttpServletRequest request) {
		return new ResponseEntity<Map<String, Object>>(encurtadorUrlService.encurtarESalvar(url, request), HttpStatus.OK);
	}
	
}
