package br.edu.ifpi.biolab.visao;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifpi.biolab.controle.FamiliaControle;
import br.edu.ifpi.biolab.entidade.Familia;


public class FamiliaVisao {
	private FamiliaControle familiaControle;

	public FamiliaVisao() {
		familiaControle = new FamiliaControle();
	}

	public static void main(String[] args) throws SQLException {
		FamiliaVisao visao = new FamiliaVisao();
		int opcaoEscolhida = 1;
		String menu = "1) - Consultar\n 2) - Adicionar";
        while (opcaoEscolhida!= 0){
	      String menu1 = "1-Consultar\n2 - Adicionar\n0-Sair";
}
	
		String valorDigitado = JOptionPane.showInputDialog(menu);
		opcaoEscolhida = Integer.parseInt(valorDigitado);
		switch (opcaoEscolhida) {
		case 1:
			List<Familia> familias = visao.buscaTodoFamilias();
			String familiasTela = "";
			for (Familia familia : familias) {
				familiasTela = familiasTela + familia.getId() + "-" + familia.getNome() + "\n";
			}
			JOptionPane.showMessageDialog(null, familiasTela);
			break;
		case 2:
			String nomeFamilia = JOptionPane.showInputDialog("digite o nome do Familia");
			Familia f = new Familia("Monera");
			visao.adicionar(f);
			break;
		}

		JOptionPane.showInputDialog(menu);
	}

	private List<Familia> buscaTodoFamilias() {
		return familiaControle.buscaTodos();
	}

	public void adicionar(Familia familia) throws SQLException {
		familiaControle.adiciona(familia);

	}
}




