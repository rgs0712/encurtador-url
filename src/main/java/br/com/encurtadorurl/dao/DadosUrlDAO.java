package br.com.encurtadorurl.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.encurtadorurl.entity.DadosUrl;
import br.com.encurtadorurl.repository.DadosUrlRepository;

@Service
public class DadosUrlDAO {
	
	@Autowired
	private DadosUrlRepository dadosUrlRepository;
	
	public DadosUrl getByUrlCode(String urlCode) {
		return dadosUrlRepository.getByUrlCode(urlCode);
	}
	
	public DadosUrl saveOrUpdate(DadosUrl dadosUrl) {
		return dadosUrlRepository.save(dadosUrl);
	}
	
}
