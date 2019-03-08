package br.com.encurtadorurl.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.encurtadorurl.entity.DadosUrl;
@Repository
public interface DadosUrlRepository extends CrudRepository<DadosUrl, Long>{

	@Query("SELECT d FROM DadosUrl d WHERE d.urlCode = :urlCode") 
	public DadosUrl getByUrlCode(String urlCode);
	
}
