package dao.categoria;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.Carro;
import entity.Categoria;
import helper.db;
import interfaces.IBancoDados;
import interfaces.IPadraoCRUD;

public class CategoriaDAO implements IPadraoCRUD<Categoria> {

	private IBancoDados bancoDados;

	public CategoriaDAO(IBancoDados bancoDados) {
		this.bancoDados = bancoDados;
	}

	private String Select_Categoria() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id_Categoria, nome, taxaDepreciacao, prazoDepreciacao, percValorResidual FROM categoria");
		return sql.toString();
	}

	public int Inserir(Categoria categoria) throws SQLException {

		int retorno = 0;

		try {
			String sql = "INSERT INTO categoria(id_Categoria, nome, taxaDepreciacao, prazoDepreciacao, percValorResidual) VALUES (?,?,?,?,?)";

			PreparedStatement statement = bancoDados.getConexao().prepareStatement(sql);

			statement.setInt(1, db.ProximaID(bancoDados.getConexao(), "id_Categoria", "categoria"));
			statement.setString(2, categoria.getnome());
			statement.setFloat(3, categoria.gettaxaDepreciacao());
			statement.setInt(4, categoria.getprazoDepreciacao());
			statement.setFloat(5, categoria.getpercValorResidual());

			retorno = bancoDados.ExecutarDDL(statement);

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
			throw sqlEx;
		}

		return retorno;
	}

	public int Deletar(int id) throws SQLException {
		int retorno = 0;
		try {

			String sql = "DELETE FROM categoria WHERE id_Categoria= " + id;

			PreparedStatement statement = bancoDados.getConexao().prepareStatement(sql);

			retorno = bancoDados.ExecutarDDL(statement);

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
			throw sqlEx;
		}

		return retorno;
	}

	public int Editar(Categoria categoria) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE categoria SET");
		sql.append(" nome = '" + categoria.getnome() + "',");
		sql.append("taxaDepreciacao = " + categoria.gettaxaDepreciacao() + ",");
		sql.append("prazoDepreciacao = " + categoria.getprazoDepreciacao() + ",");
		sql.append("percValorResidual = " + categoria.getpercValorResidual());
		sql.append(" WHERE id_Categoria = " + categoria.getid_Categoria());
		
		if(bancoDados.ExecutarDDL(sql.toString()) == 1) {
			return 2;
		}
		else {
			return -2;
		}		
	}

	public Categoria Carregar(int id) throws Exception {
		Categoria categoria = null;

		try {

			StringBuilder sql = new StringBuilder();
			sql.append(this.Select_Categoria());
			sql.append(" where id_Categoria =" + id);			

			ResultSet resultSet = bancoDados.ExecutarQuery(sql.toString());

			if (resultSet.next()) {
				categoria = this.Preencher(resultSet);
			}			

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
			throw sqlEx;
		}

		return categoria;
	}
	
	public List<Categoria> Listar() throws SQLException {
		List<Categoria> categorias = new ArrayList<Categoria>();

		try {

			StringBuilder sql = new StringBuilder();
			sql.append(this.Select_Categoria());

			ResultSet resultSet = bancoDados.ExecutarQuery(sql.toString());

			if (resultSet.next()) {
				categorias.add(this.Preencher(resultSet));
			}			

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
			throw sqlEx;
		}

		return categorias;
	}

	public Categoria Preencher(ResultSet resultSet) throws SQLException {		
		return new Categoria(resultSet.getInt("id_Categoria"), resultSet.getString("nome"), resultSet.getFloat("taxaDepreciacao"), resultSet.getInt("prazoDepreciacao"), resultSet.getFloat("percValorResidual"));
	}

}
