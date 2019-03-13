package br.com.b2w.recurso.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="planeta")
@Entity
public class Planeta {

	@Id
	private Integer id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="clima")
	private String clima;
	
	@Column(name="terreno")
	private String terreno;
	
	@Column(name="qt_aparicoes")
	private Integer quantidadeAparicoes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	public Integer getQuantidadeAparicoes() {
		return quantidadeAparicoes;
	}

	public void setQuantidadeAparicoes(Integer quantidadeAparicoes) {
		this.quantidadeAparicoes = quantidadeAparicoes;
	}
	
}
