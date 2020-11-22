package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import interfaces.IBancoDados;

public class DbMySql implements IBancoDados {
	
	private String url = "jdbc:mysql://localhost:3306/prova2bim?useTimezone=true&serverTimezone=UTC";
	private String root = "usuario";
	private String key = "123123@senha";
	
	public Connection ConectarBanco() {			
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");			
				return DriverManager.getConnection(url, root, key);
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			
			return null;
	}	
}
