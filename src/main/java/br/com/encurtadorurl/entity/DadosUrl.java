package br.com.encurtadorurl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_DADOS_URL")
public class DadosUrl {
	
	public DadosUrl() {
	}
	public DadosUrl(String urlOriginal, String urlCode, String urlEncurtada) {
		this.urlOriginal = urlOriginal;
		this.urlCode = urlCode;
		this.urlEncurtada = urlEncurtada;
		this.qtdAcessos = 0l;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="URL_ORIGINAL")
	private String urlOriginal;
	
	@Column(name="URL_CODE", unique = true, nullable = false)
	private String urlCode;

	@Column(name="URL_ENCURTADA", unique = true, nullable = false)
	private String urlEncurtada;
	
	@Column(name="QTD_ACESSOS")
	private Long qtdAcessos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrlOriginal() {
		return urlOriginal;
	}

	public void setUrlOriginal(String urlOriginal) {
		this.urlOriginal = urlOriginal;
	}

	public String getUrlCode() {
		return urlCode;
	}

	public void setUrlCode(String urlCode) {
		this.urlCode = urlCode;
	}

	public Long getQtdAcessos() {
		return qtdAcessos;
	}

	public void setQtdAcessos(Long qtdAcessos) {
		this.qtdAcessos = qtdAcessos;
	}
	public void incrementarQtdAcessos() {
		this.qtdAcessos = this.qtdAcessos +1;
	}
	
	public String getUrlEncurtada() {
		return urlEncurtada;
	}
	public void setUrlEncurtada(String urlEncurtada) {
		this.urlEncurtada = urlEncurtada;
	}
		
}
