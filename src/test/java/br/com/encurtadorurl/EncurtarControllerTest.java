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

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EncurtarControllerTest {
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	
	@Test
	public void encurtarReturnStatusCode200() {
		ResponseEntity<String> response =  restTemplate.postForEntity("/encurtarUrl/encurtar", "http://uol.com" ,String.class);
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
	}
	
	
}
