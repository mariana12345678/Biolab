package br.edu.ifpi.biolab.visao;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifpi.biolab.controle.OrdemControle;
import br.edu.ifpi.biolab.entidade.Ordem;

public class OrdemVisao {
	private static Object ordemTela;
	private OrdemControle ordemControle;

	public OrdemVisao() {
		ordemControle = new OrdemControle();
	}

	public static void main(String[] args) throws SQLException {
		OrdemVisao visao = new OrdemVisao();
		int opcaoEscolhida = 1;
		String menu = "1) - Consultar\n 2) - Adicionar";
        while (opcaoEscolhida!= 0){
	      String menu1 = "1-Consultar\n2 - Adicionar\n0-Sair";
}
	
		String valorDigitado = JOptionPane.showInputDialog(menu);
		opcaoEscolhida = Integer.parseInt(valorDigitado);
		switch (opcaoEscolhida) {
		case 1:
			List<Ordem> ordens = visao.buscaTodosOrdens();
			String ordensTela = "";
			for (Ordem ordem : ordens) {
		 ordensTela = ordensTela + ordem.getId() + "-" + ordem.getNome() + "\n";
			}
			JOptionPane.showMessageDialog(null, ordensTela);
			break;
		case 2:
			String nomeOrdem = JOptionPane.showInputDialog("digite o nome do Ordem");
			Ordem g = new Ordem("Monera");
			visao.adicionar(g);
			break;
		}

		JOptionPane.showInputDialog(menu);
	}

	private List<Ordem> buscaTodosOrdens() {
		return ordemControle.buscaTodos();
	}

	public void adicionar(Ordem ordem) throws SQLException {
		ordemControle.adiciona(ordem);

	}
}




