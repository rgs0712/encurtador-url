package br.com.encurtadorurl.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.encurtadorurl.dao.DadosUrlDAO;
import br.com.encurtadorurl.entity.DadosUrl;

@Service
public class EncurtadorUrlService {

	@Autowired
	private DadosUrlDAO dadosUrlDAO;
	

	@SuppressWarnings("static-access")
	public String urlCode() {
		return new RandomStringUtils().random(5, true, true);
	}
	
	public DadosUrl encurtarESalvar(String urlOriginal, HttpServletRequest request){
		String urlCode = urlCode();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(request.getScheme());
		sb.append("://");
		sb.append(request.getServerName());
		sb.append(":");
		sb.append(request.getServerPort());
		sb.append("/");
		sb.append(urlCode);
		
		
		DadosUrl dadosUrl = new DadosUrl(urlOriginal, urlCode, sb.toString());
		return dadosUrlDAO.saveOrUpdate(dadosUrl);
	}
	
}
