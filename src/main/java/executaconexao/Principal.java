package executaconexao;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.bancoconexao.Conexao;

public class Principal {

	public static void main(String[] args) {

		try {
			Connection conexao = new Conexao().getConexao();
			conexao.close();
			System.out.println("desconectado!");
		}

		catch (SQLException se) {
			se.printStackTrace();

		}

	}
}
