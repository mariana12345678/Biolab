package br.edu.ifpi.biolab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.edu.ifpi.biolab.entidade.Familia;

public class FamiliaDao extends Dao {
	public void adiciona(Familia familia) throws SQLException {
		String sql = "insert into familia (nome,data_inclusao,id_Ordem) " + "values (?,?,?,?)";
		PreparedStatement stmt = super.getConexao().prepareStatement(sql);

		// preenche os valores
		stmt.setString(1, familia.getNome());
		stmt.setDate(3, new java.sql.Date(familia.getDataInclusao().getTime()));
		stmt.setInt(4, familia.getFamilia().getId());

		// executa
		stmt.execute();
		stmt.close();
		System.out.println("Familia salva com sucesso");
	}

	public List<Familia> buscaTodos() throws SQLException {

		List<Familia> familia = new ArrayList<>();
		Connection con = ConnectionFactory.getConexao();
		PreparedStatement stmt = con.prepareStatement("select * from familia");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			// criando o objeto Especie
			Familia familia1 = new Familia(null);
			familia1.setId(rs.getInt("id"));
			familia1.setNome(rs.getString("nome"));

			// montando a data através do calendar
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("data_inclusao"));
			familia1.setDataInclusao(data.getTime());

			// adicionando objeto a lista
			Familia.add(familia1);
		}

		rs.close();
		stmt.close();
		return familia;
	}

}
