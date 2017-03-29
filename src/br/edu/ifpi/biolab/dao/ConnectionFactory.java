package br.edu.ifpi.biolab.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConexao() throws SQLException {
		try {
			return DriverManager.getConnection("jdbc:mysql://192.168.3.142/luisMarydb", "aluno", "aluno");

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}