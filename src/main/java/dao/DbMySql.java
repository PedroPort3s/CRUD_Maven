package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import interfaces.IBancoDados;

public class DbMySql implements IBancoDados {

	private String url = "jdbc:mysql://localhost:3306/prova2bim?useTimezone=true&serverTimezone=UTC";
	private String root = "usuario";
	private String key = "123123@senha";
	private Connection conexao = null;

	public Connection getConexao() {
		return conexao;
	}

	public int ConectarBanco() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexao = DriverManager.getConnection(url, root, key);
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return 0;
	}

	public void ComecarTransacao(boolean Comeca) throws SQLException {
		if (conexao != null) {
			conexao.setAutoCommit(!Comeca);
		}
	}

	public void CommitTransacao() throws SQLException {
		if (conexao != null) {
			conexao.commit();
		}
	}

	public void RollbackTransacao() throws SQLException {
		if (conexao != null) {
			conexao.rollback();
		}
	}
	
	public void DesconectarBanco(){
		if (conexao != null) {
			try {
				conexao.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}

	public ResultSet ExecutarQuery(String comandoSQL) {
		PreparedStatement statement;

		try {
			statement = conexao.prepareStatement(comandoSQL);
			return statement.executeQuery();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public int ExecutarDDL(String comandoSQL) {
		PreparedStatement statement;

		try {
			statement = conexao.prepareStatement(comandoSQL);
			return statement.executeUpdate(comandoSQL);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return -1;
		}
	}
	
	public int ExecutarDDL(PreparedStatement statement) {

		try {
			return statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return -1;
		}
	}
}
