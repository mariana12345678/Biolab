package br.edu.ifpi.biolab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.edu.ifpi.biolab.entidade.Ordem;

public class OrdemDao extends Dao {
public void adiciona(Ordem ordem) throws SQLException {
		
		String sql = "insert into Filo (nome,data_inclusao,id_Reino) " + "values (?,?,?,?)";
		PreparedStatement stmt =super.getConexao().prepareStatement(sql);

		// preenche os valores
		stmt.setString(1, ordem.getNome());
		stmt.setDate(3, new java.sql.Date(ordem.getDataInclusao().getTime()));
		stmt.setInt(4, ordem.getOrdem().getId());

		// executa
		stmt.execute();
		stmt.close();
		System.out.println("Ordem salva com sucesso");
		
	}

	public List<Ordem> buscaTodos() throws SQLException {

		List<Ordem> ordem = new ArrayList<>();
		Connection con = ConnectionFactory.getConexao();
		PreparedStatement stmt = con.prepareStatement("select * from filo");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			// criando o objeto Especie
			Ordem ordem1 = new Ordem (null);
			ordem1.setId(rs.getInt("id"));
			ordem1.setNome(rs.getString("nome"));

			// montando a data através do calendar
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("data_inclusao"));
			ordem1.setDataInclusao(data.getTime());

			// adicionando objeto a lista
			Ordem.add(ordem1);
		}

		rs.close();
		stmt.close();
		return ordem;
	}

}


