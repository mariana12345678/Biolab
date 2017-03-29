package br.edu.ifpi.biolab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.edu.ifpi.biolab.entidade.Filo;

public class FiloDao extends Dao {
public void adiciona(Filo filo) throws SQLException {
		
		String sql = "insert into Filo (nome,data_inclusao,id_Reino) " + "values (?,?,?,?)";
		PreparedStatement stmt =super.getConexao().prepareStatement(sql);

		// preenche os valores
		stmt.setString(1, filo.getNome());
		stmt.setDate(3, new java.sql.Date(filo.getDataInclusao().getTime()));
		stmt.setInt(4, filo.getFilo().getId());

		// executa
		stmt.execute();
		stmt.close();
		System.out.println("Filo salva com sucesso");
		
	}

	public List<Filo> buscaTodos() throws SQLException {

		List<Filo> filo = new ArrayList<>();
		Connection con = ConnectionFactory.getConexao();
		PreparedStatement stmt = con.prepareStatement("select * from filo");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			// criando o objeto Especie
			Filo filo1 = new Filo (null);
			filo1.setId(rs.getInt("id"));
			filo1.setNome(rs.getString("nome"));

			// montando a data através do calendar
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("data_inclusao"));
			filo1.setDataInclusao(data.getTime());

			// adicionando objeto a lista
			Filo.add(filo1);
		}

		rs.close();
		stmt.close();
		return filo;
	}

}
