package br.edu.ifpi.biolab.entidade;

import java.util.Date;

public class Ordem {
	
	private String nome;
    private int id;
    private Date dataInclusao;
    
	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Ordem(String nome) {
		this.nome = nome;
	}




	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Filo getOrdem() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void add(Ordem ordem1) {
		// TODO Auto-generated method stub
		
	}

	




		
	}

