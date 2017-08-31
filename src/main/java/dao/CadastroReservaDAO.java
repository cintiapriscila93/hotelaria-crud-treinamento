package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bancoconexao.Conexao;
import tablecadastroreserva.CadastroReserva;

//classe que vai encapsular todas operações referente ao banco de dados.//
public class CadastroReservaDAO {
	private Connection connection;

	public CadastroReservaDAO() {
		this.connection = new Conexao().getConexao();
	}

	public void adiciona(CadastroReserva cadastroreserva) {
		String sql = "insert into cadastroreserva"
				+ " (nomedocliente,rg,contato,numerodoquarto,andar, datainiciodareserva, datafimdareserva,status)"
				+ " values (?,?,?,?,?,?,?,?);";
		try {
			PreparedStatement dadoscadastro = connection.prepareStatement(sql);
			dadoscadastro.setString(1, cadastroreserva.getNomeDoCliente());
			dadoscadastro.setString(2, cadastroreserva.getRg());
			dadoscadastro.setString(3, cadastroreserva.getContato());
			dadoscadastro.setString(4, cadastroreserva.getNumerodoquarto());
			dadoscadastro.setString(5, cadastroreserva.getAndar());
			dadoscadastro.setString(6, cadastroreserva.getDatainiciodareserva());
			dadoscadastro.setString(7, cadastroreserva.getDatafimdareserva());
			dadoscadastro.setString(8, cadastroreserva.getStatus());

			dadoscadastro.execute();
			dadoscadastro.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(CadastroReserva cadastroreserva) {
		String sql = "update cadastroreserva set nomedocliente=?, rg=?, contato=?, numerodoquarto=?, andar=?, datainiciodareserva=?, datafimdareserva=?, status =? where id_cadastro=?";
		try {
			PreparedStatement dadoscadastro = connection.prepareStatement(sql);

			dadoscadastro.setString(1, cadastroreserva.getNomeDoCliente());
			dadoscadastro.setString(2, cadastroreserva.getRg());
			dadoscadastro.setString(3, cadastroreserva.getContato());
			dadoscadastro.setString(4, cadastroreserva.getNumerodoquarto());
			dadoscadastro.setString(5, cadastroreserva.getAndar());
			dadoscadastro.setString(6, cadastroreserva.getDatainiciodareserva());
			dadoscadastro.setString(7, cadastroreserva.getDatafimdareserva());
			dadoscadastro.setString(8, cadastroreserva.getStatus());
			dadoscadastro.setInt(9, cadastroreserva.getId_cadastro());

			dadoscadastro.execute();
			dadoscadastro.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<CadastroReserva> getLista() {
		try {
			List<CadastroReserva> listaCadastroreserva = new ArrayList<CadastroReserva>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from cadastroreserva");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				CadastroReserva cadastroreserva = new CadastroReserva();

				cadastroreserva.setId_cadastro(rs.getInt("id_cadastro"));
				cadastroreserva.setNomedocliente(rs.getString("nomedocliente"));
				cadastroreserva.setRg(rs.getString("rg"));
				cadastroreserva.setContato(rs.getString("contato"));
				cadastroreserva.setNumerodoquarto(rs.getString("numerodoquarto"));
				cadastroreserva.setAndar(rs.getString("andar"));
				cadastroreserva.setDatainiciodareserva(rs.getString("datainiciodareserva"));
				cadastroreserva.setDatafimdareserva(rs.getString("datafimdareserva"));
				cadastroreserva.setStatus(rs.getString("status"));

				listaCadastroreserva.add(cadastroreserva);

			}
			rs.close();
			stmt.close();
			return listaCadastroreserva;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(CadastroReserva cadastroreserva) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from cadastroreserva where id_cadastro=?");
			stmt.setInt(1, cadastroreserva.getId_cadastro());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
