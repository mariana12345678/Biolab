package br.edu.ifpi.biolab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.edu.ifpi.biolab.entidade.Classe;


public class ClasseDao extends Dao {
public void adiciona(Classe classe) throws SQLException {
		
		String sql = "insert into classe (nome,data_inclusao,id_Reino) " + "values (?,?,?,?)";
		PreparedStatement stmt =super.getConexao().prepareStatement(sql);

		// preenche os valores
		stmt.setString(1, classe.getNome());
		stmt.setDate(3, new java.sql.Date(classe.getDataInclusao().getTime()));
		stmt.setInt(4, classe.getClasse().getId());

		// executa
		stmt.execute();
		stmt.close();
		System.out.println("Classe salva com sucesso");
		
	}

	public List<Classe> buscaTodos() throws SQLException {

		List<Classe> classe = new ArrayList<>();
		Connection con = ConnectionFactory.getConexao();
		PreparedStatement stmt = con.prepareStatement("select * from classe");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			// criando o objeto Especie
			Classe classe1 = new Classe (null);
			classe1.setId(rs.getInt("id"));
			classe1.setNome(rs.getString("nome"));

			// montando a data através do calendar
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("data_inclusao"));
			classe1.setDataInclusao(data.getTime());

			// adicionando objeto a lista
			Classe.add(classe1);
		}

		rs.close();
		stmt.close();
		return classe;
	}

}


