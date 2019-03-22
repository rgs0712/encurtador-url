package br.com.encurtadorurl;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.gson.Gson;

import br.com.encurtadorurl.entity.DadosUrl;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RedirecionarControllerTest {
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	
	@Test
	public void redirecionarReturnStatusCode200() {
		ResponseEntity<String> responseEncurtarUrl =  restTemplate.postForEntity("/encurtarUrl/encurtar", "http://uol.com" ,String.class);
		Assertions.assertThat(responseEncurtarUrl.getStatusCodeValue()).isEqualTo(200);
		Gson json = new Gson();
		
		DadosUrl dadosUrl = json.fromJson(responseEncurtarUrl.getBody(), DadosUrl.class);
		
		
		ResponseEntity<String> responseRedirecionar =  restTemplate.getForEntity("/redir/"+dadosUrl.getUrlCode(), String.class);
		Assertions.assertThat(responseRedirecionar.getStatusCodeValue()).isEqualTo(200);
	}
}
