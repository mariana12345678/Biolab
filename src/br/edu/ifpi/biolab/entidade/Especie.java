package br.edu.ifpi.biolab.entidade;

import java.util.Date;

public class Especie {
	
	private int id;
	private String nomeVulgar;
	private String nomeCientifico;
	private Date dataInclusao;
	private Genero genero;


	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getNomeVulgar() {
		return nomeVulgar;
	}

	public String getNomeCientifico() {
		return nomeCientifico;
	}

	public Date getDataInclusao() {
		return dataInclusao;

	}

	public Genero getGenero() {
		return genero;
	}

	public void setNomeVulgar(String nomeVulgar) {
		this.nomeVulgar = nomeVulgar;
	}

	public void setNomeCientifico(String nomeCientifico) {
		this.nomeCientifico = nomeCientifico;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

}
