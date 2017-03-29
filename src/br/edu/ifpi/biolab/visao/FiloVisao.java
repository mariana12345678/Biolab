package br.edu.ifpi.biolab.visao;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifpi.biolab.controle.FiloControle;
import br.edu.ifpi.biolab.entidade.Filo;


public class FiloVisao {
	private FiloControle filoControle;

	public FiloVisao() {
		filoControle = new FiloControle();
	}

	public static void main(String[] args) throws SQLException {
		FiloVisao visao = new FiloVisao();
		int opcaoEscolhida = 1;
		String menu = "1) - Consultar\n 2) - Adicionar";
        while (opcaoEscolhida!= 0){
	      String menu1 = "1-Consultar\n2 - Adicionar\n0-Sair";
}
	
		String valorDigitado = JOptionPane.showInputDialog(menu);
		opcaoEscolhida = Integer.parseInt(valorDigitado);
		switch (opcaoEscolhida) {
		case 1:
			List<Filo> Filos = visao.buscaTodosFilos();
			String filosTela = "";
			for (Filo filo : Filos) {
				filosTela = filosTela + filo.getId() + "-" + filo.getNome() + "\n";
			}
			JOptionPane.showMessageDialog(null, filosTela);
			break;
		case 2:
			String nomeFilo = JOptionPane.showInputDialog("digite o nome do filo");
			Filo f = new Filo("Monera");
			visao.adicionar(f);
			break;
		}

		JOptionPane.showInputDialog(menu);
	}

	private List<Filo> buscaTodosFilos() {
		return filoControle.buscaTodos();
	}

	public void adicionar(Filo filo) throws SQLException {
		filoControle.adiciona(filo);

	}
}




