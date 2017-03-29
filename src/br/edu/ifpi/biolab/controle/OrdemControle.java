package br.edu.ifpi.biolab.controle;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpi.biolab.dao.OrdemDao;
import br.edu.ifpi.biolab.entidade.Ordem;

public class OrdemControle {
	private OrdemDao ordemDao;
	

	public OrdemControle() {
		ordemDao = new OrdemDao();
	}

	public void adiciona(Ordem ordem) throws SQLException {
		ordemDao.adiciona(ordem);
		ordemDao.fechaConexao();
	}

	public List<Ordem> buscaTodos() {
		return null;

	}

}
