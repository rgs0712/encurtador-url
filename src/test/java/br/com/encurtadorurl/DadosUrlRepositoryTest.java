package br.com.encurtadorurl;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.encurtadorurl.entity.DadosUrl;
import br.com.encurtadorurl.repository.DadosUrlRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DadosUrlRepositoryTest {
	@Autowired
	private DadosUrlRepository dadosUrlRepository;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void persistData() {
		DadosUrl dadosUrl = new DadosUrl("http://uol.com", "ASD", "http://teste/ASD");
		
		this.dadosUrlRepository.save(dadosUrl);
		
		Assertions.assertThat(dadosUrl.getId()).isNotNull();
		Assertions.assertThat(dadosUrl.getUrlOriginal()).isEqualTo("http://uol.com");
		Assertions.assertThat(dadosUrl.getUrlCode()).isEqualTo("ASD");
		Assertions.assertThat(dadosUrl.getUrlEncurtada()).isEqualTo("http://teste/ASD");
		
		
		dadosUrl.setUrlOriginal("http://uol.com");
		dadosUrl.setUrlCode("ASD2");
		dadosUrl.setUrlEncurtada("http://teste2/ASD2");
		
		this.dadosUrlRepository.save(dadosUrl);
		
		Assertions.assertThat(dadosUrl.getId()).isNotNull();
		Assertions.assertThat(dadosUrl.getUrlOriginal()).isEqualTo("http://uol.com");
		Assertions.assertThat(dadosUrl.getUrlCode()).isEqualTo("ASD2");
		Assertions.assertThat(dadosUrl.getUrlEncurtada()).isEqualTo("http://teste2/ASD2");
	}
	
	@Test
	public void deletData() {
		DadosUrl dadosUrl = new DadosUrl("http://uol.com", "ASD", "http://teste/ASD");
		
		this.dadosUrlRepository.save(dadosUrl);
		
		Assertions.assertThat(dadosUrlRepository.findById(dadosUrl.getId())).isNotNull();
		
		this.dadosUrlRepository.delete(dadosUrl);
		
		Assertions.assertThat(dadosUrlRepository.findById(dadosUrl.getId())).isEmpty();
	}
	
	@Test
	public void getByUrlCodeData() {
		DadosUrl dadosUrl = new DadosUrl("http://uol.com", "ASD", "http://teste/ASD");
		
		this.dadosUrlRepository.save(dadosUrl);
		
		this.dadosUrlRepository.getByUrlCode("ASD");
		
		Assertions.assertThat(dadosUrl).isNotNull();
		
	}
	
}
