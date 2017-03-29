package br.edu.ifpi.biolab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.edu.ifpi.biolab.entidade.Genero;


public class GeneroDao extends Dao{
private List<Genero> genero;

public void adiciona(Genero genero) throws SQLException {
		
		String sql = "insert into Genero (nome,data_inclusao,id_Especie) " + "values (?,?,?,?)";
		PreparedStatement stmt =super.getConexao().prepareStatement(sql);

		// preenche os valores
		stmt.setString(1, genero.getNome());
		stmt.setDate(3, new java.sql.Date(genero.getDataInclusao().getTime()));
		stmt.setInt(4, genero.getGenero().getId());

		// executa
		stmt.execute();
		stmt.close();
		System.out.println("Genero salva com sucesso");
		
	}

	public List<Genero> buscaTodos() throws SQLException {

		List<Genero> ordem = new ArrayList<>();
		Connection con = ConnectionFactory.getConexao();
		PreparedStatement stmt = con.prepareStatement("select * from Genero");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			// criando o objeto Especie
			Genero genero1 = new Genero (null);
			genero1.setId(rs.getInt("id"));
			genero1.setNome(rs.getString("nome"));

			// montando a data através do calendar
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("data_inclusao"));
			genero1.setDataInclusao(data.getTime());

			// adicionando objeto a lista
			Genero.add(genero1);
		}

		rs.close();
		stmt.close();
		return genero;
	}

}




