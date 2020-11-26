package dao.automovel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.categoria.CategoriaDAO;
import entity.Caminhao;
import helper.db;
import interfaces.IBancoDados;
import interfaces.IPadraoCRUD;

public class CaminhaoDAO implements IPadraoCRUD<Caminhao> {

	private IBancoDados bancoDados;
	
	public CaminhaoDAO(IBancoDados bancoDados) {
		this.bancoDados = bancoDados;
	}
	
	private String Select_Caminhao() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT a.id, a.nome,a.quilometragem, a.qtdRodas, a.cor, a.valor, a.id_Categoria, c.qtdEixos, c.id_Reboque ");
		sql.append(" FROM automovel as a inner join caminhao as c on c.id_Aut = a.id");
		return sql.toString();
	}

	public int Inserir(Caminhao caminhao) throws SQLException, ClassNotFoundException {
		int retorno = 0;

		try {
			String sqlAutomovel = "INSERT INTO automovel(id, nome,quilometragem, qtdRodas, cor, valor,id_Categoria) VALUES (?,?,?,?,?,?,?)";

			PreparedStatement statement = bancoDados.getConexao().prepareStatement(sqlAutomovel);
			
			caminhao.set_id(db.ProximaID(bancoDados.getConexao(), "id", "automovel"));
			
			statement.setInt(1, caminhao.get_id());
			statement.setString(2, caminhao.get_nome());
			statement.setDouble(3, caminhao.getQuilometragem());
			statement.setInt(4, caminhao.get_qtdRodas());
			statement.setString(5, caminhao.get_cor());
			statement.setDouble(6, caminhao.get_valor());
			statement.setInt(7, caminhao.get_Categoria().getid_Categoria());
			
			if(bancoDados.ExecutarDDL(statement) == 1) {
				
				String sqlCaminhao = "INSERT INTO caminhao(id_Aut, qtdEixos, id_Reboque) VALUES (?,?,?)";

				statement = bancoDados.getConexao().prepareStatement(sqlCaminhao);

				statement.setInt(1, caminhao.get_id());
				statement.setInt(2, caminhao.get_qtdEixos());
				statement.setInt(3, caminhao.getReboque().getId());
				
				retorno = bancoDados.ExecutarDDL(statement);
			}
			else {
				retorno = -1;
			}			

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
			throw sqlEx;
		}

		return retorno;
	}

	public int Deletar(int id) throws SQLException {
		int retorno = 0;
		try 
		{
			String sqlCaminhao = "DELETE FROM caminhao WHERE id_Aut=" + id;
			
			String sqlAutomovel = "DELETE FROM automovel WHERE id=" + id;

			PreparedStatement statement = bancoDados.getConexao().prepareStatement(sqlCaminhao);
			
			if(bancoDados.ExecutarDDL(statement) == 1)
			{
				statement = bancoDados.getConexao().prepareStatement(sqlAutomovel);
				
				retorno = bancoDados.ExecutarDDL(statement);
			}
			else 
			{
				retorno = -1;
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
			throw sqlEx;
		}

		return retorno;
	}

	public int Editar(Caminhao caminhao) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE automovel SET");
		sql.append(" nome= '" + caminhao.get_nome() + "',");
		sql.append("quilometragem = " + caminhao.getQuilometragem() + ",");
		sql.append("qtdRodas = " + caminhao.get_qtdRodas() + ",");
		sql.append("cor = '" + caminhao.get_cor() + "',");
		sql.append("valor = " + caminhao.get_valor() + ",");
		sql.append("id_Categoria = " + caminhao.get_Categoria().getid_Categoria());
		sql.append(" WHERE id = " + caminhao.get_id());
		
		if(bancoDados.ExecutarDDL(sql.toString()) == 1) {
			
			sql = new StringBuilder();
			sql.append("UPDATE caminhao SET");
			sql.append(" qtdEixos=" + caminhao.get_qtdEixos() + ",");
			sql.append(" id_Reboque=" + caminhao.getReboque().getId());
			sql.append(" WHERE id_Aut = " + caminhao.get_id());	
			
			return bancoDados.ExecutarDDL(sql.toString());
		}
		else {
			return -2;
		}
	}

	public Caminhao Carregar(int id) throws Exception {
		Caminhao caminhao = null;

		try {

			StringBuilder sql = new StringBuilder();
			sql.append(this.Select_Caminhao());
			sql.append(" where a.id =" + id);			

			ResultSet resultSet = bancoDados.ExecutarQuery(sql.toString());

			if (resultSet.next()) {
				caminhao = this.Preencher(resultSet);
			}			

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
			throw sqlEx;
		}

		return caminhao;
	}

	public Caminhao Preencher(ResultSet resultSet) throws Exception {
		return new Caminhao(resultSet.getInt("a.id"),
				resultSet.getString("a.nome"),
				resultSet.getInt("a.qtdRodas"),
				resultSet.getString("a.cor"),
				resultSet.getDouble("a.valor"),
				new CategoriaDAO(bancoDados).Carregar(resultSet.getInt("a.id_Categoria")),
				resultSet.getDouble("a.quilometragem"),
				resultSet.getInt("c.qtdEixos"),
				new ReboqueDAO(bancoDados).Carregar(resultSet.getInt("c.id_Reboque")));
	}

	public List<Caminhao> Listar() throws Exception {
		List<Caminhao> caminhoes = new ArrayList<Caminhao>();

		try {

			StringBuilder sql = new StringBuilder();
			sql.append(this.Select_Caminhao());				

			ResultSet resultSet = bancoDados.ExecutarQuery(sql.toString());

			while (resultSet.next()) {
				caminhoes.add(this.Preencher(resultSet));
			}			

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
			throw sqlEx;
		}

		return caminhoes;
	}

}
