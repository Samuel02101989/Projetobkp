package br.com.clinica.dao;

import java.sql.Connection;
import java.sql.DriverManager;

// Classe criada para efetuar conexao de banco com relatorio JasperReport

public class ConnectionFactory {

	public static Connection conector() {
		java.sql.Connection conexao = null;
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost/clinica";
		String user = "root";
		String password = "";
		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(url,user,password);
			return conexao;
			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		

	}
}
