package br.com.bancoconexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public Connection getConexao() {
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Conectando ao banco....");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/cadastrohotelresttime?useTimezone=true&serverTimezone=UTC&useSSL=false",
					"root", "Cici123");
			System.out.println("Conectado!");

		}

		catch (SQLException se) {
			System.out.println("Problemas ao conectar ao banco" + se);
		}

		catch (ClassNotFoundException cf)

		{
			cf.printStackTrace();
		}

		return conn;
	}
}
