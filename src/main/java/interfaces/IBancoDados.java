package interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface IBancoDados {
	public int ConectarBanco();
	public Connection getConexao();
	public void ComecarTransacao(boolean Comeca) throws SQLException;
	public void CommitTransacao() throws SQLException ;
	public void RollbackTransacao() throws SQLException;
	public ResultSet ExecutarQuery(String comandoSQL);
	public int ExecutarDDL(String comandoSQL);
	public int ExecutarDDL(PreparedStatement statement);
	void DesconectarBanco();
}
