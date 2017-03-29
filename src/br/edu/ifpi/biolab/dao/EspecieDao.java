package br.edu.ifpi.biolab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.edu.ifpi.biolab.entidade.Especie;

public class EspecieDao extends Dao {

	public void adiciona(Especie especie) throws SQLException {
		
		String sql = "insert into Especie (nome_vulgar,nome_cientifico, data_inclusao,id_genero) " + "values (?,?,?,?)";
		PreparedStatement stmt = super.getConexao().prepareStatement(sql);

		// preenche os valores
		stmt.setString(1, especie.getNomeVulgar());
		stmt.setString(2, especie.getNomeCientifico());
		stmt.setDate(3, new java.sql.Date(especie.getDataInclusao().getTime()));
		stmt.setInt(4, especie.getGenero().getId());

		// executa
		stmt.execute();
		stmt.close();
		System.out.println("Especie salva com sucesso");
		 
	}
	public List<Especie> buscaTodos() throws SQLException {

		List<Especie> especies = new ArrayList<>();
		Connection con = ConnectionFactory.getConexao();
		PreparedStatement stmt = con.prepareStatement("select * from especie");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			// criando o objeto Especie
			Especie especie = new Especie();
			especie.setId(rs.getInt("id"));
			especie.setNomeVulgar(rs.getString("nome_vulgar"));
			especie.setNomeCientifico(rs.getString("nome_cientifico"));

			// montando a data através do calendar
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("data_inclusao"));
			especie.setDataInclusao(data.getTime());

			// adicionando objeto a lista
			especies.add(especie);
		}

		rs.close();
		stmt.close();
		return especies;
	}

}
