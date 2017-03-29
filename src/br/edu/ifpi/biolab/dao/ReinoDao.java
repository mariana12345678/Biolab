package br.edu.ifpi.biolab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import br.edu.ifpi.biolab.entidade.Reino;

public class ReinoDao extends Dao {

	public void adiciona(Reino reino) throws SQLException {
		
		String sql = "insert into Reino (nome,data_inclusao,id_Filo) " + "values (?,?,?,?)";
		PreparedStatement stmt = super.getConexao().prepareStatement(sql);

		// preenche os valores
		stmt.setString(1, reino.getNome());
		stmt.setDate(3, new java.sql.Date(reino.getDataInclusao().getTime()));
		stmt.setInt(4, reino.getFilo().getId());

		// executa
		stmt.execute();
		stmt.close();
		System.out.println("Reino salva com sucesso");
		
	}

	public List<Reino> buscaTodos() throws SQLException {

		List<Reino> reino = new ArrayList<>();
		Connection con = ConnectionFactory.getConexao();
		PreparedStatement stmt = con.prepareStatement("select * from reino");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			// criando o objeto Especie
			Reino reino1 = new Reino(null);
			reino1.setId(rs.getInt("id"));
			reino1.setNome(rs.getString("nome"));

			// montando a data através do calendar
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("data_inclusao"));
			reino1.setDataInclusao(data.getTime());

			// adicionando objeto a lista
			Reino.add(reino1);
		}

		rs.close();
		stmt.close();
		return reino;
	}

}
