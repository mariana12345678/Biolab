package br.edu.ifpi.biolab.controle;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpi.biolab.dao.ClasseDao;
import br.edu.ifpi.biolab.entidade.Classe;



public class ClasseControle {
	private ClasseDao classeDao;

	public ClasseControle() {
		classeDao = new ClasseDao ();
	}

	public void adiciona(Classe classe) throws SQLException {
		classeDao.adiciona(classe);
		classeDao.fechaConexao();
	}

	public List<Classe> buscaTodos() {
		return null;

	}

}


