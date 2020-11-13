package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import interfaces.IBancoDados;

public class DbMySql implements IBancoDados {
	
	private String url = "jdbc:mysql://localhost:3306/prova1bim?useTimezone=true&serverTimezone=UTC";
	private String root = "root";
	private String key = "Srv20@@";

	public Connection ConectarBanco() throws ClassNotFoundException, SQLException {			
			Class.forName("com.mysql.cj.jdbc.Driver");			
			return DriverManager.getConnection(url, root, key);
	}

}
