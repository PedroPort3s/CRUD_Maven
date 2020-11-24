package dao.automovel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.Reboque;
import helper.db;
import interfaces.IBancoDados;

public class ReboqueDAO {
	private IBancoDados bancoDados = null;
	
	public ReboqueDAO(IBancoDados bancoDados) {
		this.bancoDados = bancoDados;
	}
	
	private String Select_Reboque() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id_Reboque, nomeReboque, quilometragemReboque, valorReboque FROM reboque");
		return sql.toString();
	}

	public int Inserir(Reboque reboque) throws SQLException {

		int retorno = 0;

		try {
			String sql = "INSERT INTO reboque(id_Reboque, nomeReboque, quilometragemReboque, valorReboque) VALUES (?,?,?,?)";

			PreparedStatement statement = bancoDados.getConexao().prepareStatement(sql);

			statement.setInt(1, db.ProximaID(bancoDados.getConexao(), "id_Reboque", "reboque"));
			statement.setString(2, reboque.getNomeReboque());
			statement.setDouble(3, reboque.getQuilometragem());
			statement.setDouble(4, reboque.getValorReboque());

			retorno = bancoDados.ExecutarDDL(statement);

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
			throw sqlEx;
		}

		return retorno;
	}
	
	public Reboque Carregar(int id) throws Exception {
		Reboque reboque = null;

		try {

			StringBuilder sql = new StringBuilder();
			sql.append(this.Select_Reboque());
			sql.append(" where id_Reboque =" + id);			

			ResultSet resultSet = bancoDados.ExecutarQuery(sql.toString());

			if (resultSet.next()) {
				reboque = this.Preencher(resultSet);
			}			

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
			throw sqlEx;
		}

		return reboque;
	}
	
	public List<Reboque> Listar() throws Exception {
		List<Reboque> reboques = new ArrayList<Reboque>();

		try {

			StringBuilder sql = new StringBuilder();
			sql.append(this.Select_Reboque());

			ResultSet resultSet = bancoDados.ExecutarQuery(sql.toString());

			if (resultSet.next()) {
				reboques.add(this.Preencher(resultSet));
			}			

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
			throw sqlEx;
		}

		return reboques;
	}
	
	public Reboque Preencher(ResultSet resultSet) throws SQLException {		
		return new Reboque(resultSet.getInt("id_Reboque"), resultSet.getString("nomeReboque"), resultSet.getDouble("quilometragemReboque"), resultSet.getDouble("valorReboque"));
	}
}
