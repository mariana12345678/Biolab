package br.edu.ifpi.biolab.controle;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpi.biolab.dao.ReinoDao;
import br.edu.ifpi.biolab.entidade.Reino;

public class ReinoControle {

	private ReinoDao reinoDao;

	public ReinoControle() {
		reinoDao = new ReinoDao();
	}

	public void adiciona(Reino reino) throws SQLException {
		reinoDao.adiciona(reino);
		reinoDao.fechaConexao();
	}

	public List<Reino> buscaTodos() {
		return null;

	}

}
