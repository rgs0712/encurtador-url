package br.com.encurtadorurl.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.encurtadorurl.entity.DadosUrl;
import br.com.encurtadorurl.repository.DadosUrlRepository;

@Service
public class EncurtadorUrlService {

	@Autowired
	private DadosUrlRepository dadosUrlRepository;
	

	@SuppressWarnings("static-access")
	public String urlCode() {
		return new RandomStringUtils().random(5, true, true);
	}
	
	public Map<String, Object> encurtarESalvar(String urlOriginal, HttpServletRequest request){
		Map<String, Object> retorno = new HashMap<>();
		String urlCode = urlCode();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(request.getRequestURL().toString().replace(request.getRequestURI(), "/"));
		sb.append("redir/");
		sb.append(urlCode);
		
		DadosUrl dadosUrl = new DadosUrl(urlOriginal, urlCode, sb.toString());
		dadosUrl = dadosUrlRepository.save(dadosUrl);
		
		retorno.put("dadosUrl", dadosUrl);
		return retorno;
	}

	public String getByUrlCode(String urlCode) {
		DadosUrl retorno = dadosUrlRepository.getByUrlCode(urlCode);
		retorno.incrementarQtdAcessos();

		dadosUrlRepository.save(retorno);
		
		return retorno.getUrlOriginal();
	}
	
	
	
}
