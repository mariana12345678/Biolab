package br.edu.ifpi.biolab.visao;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifpi.biolab.controle.ReinoControle;
import br.edu.ifpi.biolab.entidade.Reino;

public class ReinoVisao {
	private ReinoControle reinoControle;

	public ReinoVisao() {
		reinoControle = new ReinoControle();
	}

	public static void main(String[] args) throws SQLException {
		ReinoVisao visao = new ReinoVisao();
		int opcaoEscolhida = 1;
		String menu = "1) - Consultar\n 2) - Adicionar";
        while (opcaoEscolhida!= 0){
	      String menu1 = "1-Consultar\n2 - Adicionar\n0-Sair";
}
	
		String valorDigitado = JOptionPane.showInputDialog(menu);
		opcaoEscolhida = Integer.parseInt(valorDigitado);
		switch (opcaoEscolhida) {
		case 1:
			List<Reino> reinos = visao.buscaTodosReinos();
			String reinosTela = "";
			for (Reino reino : reinos) {
				reinosTela = reinosTela + reino.getId() + "-" + reino.getNome() + "\n";
			}
			JOptionPane.showMessageDialog(null, reinosTela);
			break;
		case 2:
			String nomeReino = JOptionPane.showInputDialog("digite o nome do Reino");
			Reino r = new Reino("Monera");
			visao.adicionar(r);
			break;
		}

		JOptionPane.showInputDialog(menu);
	}

	private List<Reino> buscaTodosReinos() {
		return reinoControle.buscaTodos();
	}

	public void adicionar(Reino reino) throws SQLException {
		reinoControle.adiciona(reino);

	}
}
