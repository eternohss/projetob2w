package br.com.b2w.recurso.dto;

import java.io.Serializable;

public class PlanetaDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1119145211530977069L;

	private Integer id;
	
	private String nome;
	
	private String clima;
	
	private String terreno;
	
	private Integer quantidadeAparicoes;
	
	public PlanetaDto() {
	}

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
