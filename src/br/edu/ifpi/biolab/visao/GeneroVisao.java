package br.edu.ifpi.biolab.visao;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifpi.biolab.controle.GeneroControle;
import br.edu.ifpi.biolab.entidade.Genero;


public class GeneroVisao {
	private GeneroControle generoControle;

	public GeneroVisao() {
		generoControle = new GeneroControle();
	}

	public static void main(String[] args) throws SQLException {
		GeneroVisao visao = new GeneroVisao();
		int opcaoEscolhida = 1;
		String menu = "1) - Consultar\n 2) - Adicionar";
        while (opcaoEscolhida!= 0){
	      String menu1 = "1-Consultar\n2 - Adicionar\n0-Sair";
}
	
		String valorDigitado = JOptionPane.showInputDialog(menu);
		opcaoEscolhida = Integer.parseInt(valorDigitado);
		switch (opcaoEscolhida) {
		case 1:
			List<Genero> generos = visao.buscaTodosGeneros();
			String generosTela = "";
			for (Genero genero : generos) {
				generosTela = generosTela + genero.getId() + "-" + genero.getNome() + "\n";
			}
			JOptionPane.showMessageDialog(null, generosTela);
			break;
		case 2:
			String nomeGenero = JOptionPane.showInputDialog("digite o nome do Genero");
			Genero g = new Genero("Monera");
			visao.adicionar(g);
			break;
		}

		JOptionPane.showInputDialog(menu);
	}

	private List<Genero> buscaTodosGeneros() {
		return generoControle.buscaTodos();
	}

	public void adicionar(Genero genero) throws SQLException {
		generoControle.adiciona(genero);

	}
}


