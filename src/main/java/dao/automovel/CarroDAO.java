package dao.automovel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.categoria.CategoriaDAO;
import entity.Carro;
import entity.Categoria;
import helper.db;
import interfaces.IBancoDados;
import interfaces.IPadraoCRUD;

public class CarroDAO implements IPadraoCRUD<Carro> {

	private IBancoDados bancoDados;

	public CarroDAO(IBancoDados bancoDados) {
		this.bancoDados = bancoDados;
	}

	private String SelectCarro() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT a.id, a.nome,a.quilometragem, a.qtdRodas, a.cor, a.valor, a.id_Categoria, c.qtdPortas ");
		sql.append(" FROM automovel as a inner join carro as c on c.id_Aut = a.id;");
		return sql.toString();
	}

	public int Inserir(Carro carro) throws SQLException, ClassNotFoundException {
		int retorno = 0;

		try {
			String sqlAutomovel = "INSERT INTO automovel(id, nome,quilometragem, qtdRodas, cor, valor,id_Categoria) VALUES (?,?,?,?,?,?,?)";

			PreparedStatement statement = bancoDados.getConexao().prepareStatement(sqlAutomovel);
			
			carro.set_id(db.ProximaID(bancoDados.getConexao(), "id", "automovel"));
			
			statement.setInt(1, carro.get_id());
			statement.setString(2, carro.get_nome());
			statement.setDouble(3, carro.getQuilometragem());
			statement.setInt(4, carro.get_qtdRodas());
			statement.setString(5, carro.get_cor());
			statement.setDouble(6, carro.get_valor());
			statement.setInt(7, carro.get_Categoria().getid_Categoria());
			
			if(bancoDados.ExecutarDDL(statement) == 1) {
				
				String sqlCarro = "INSERT INTO carro(id_Aut, qtdPortas) VALUES (?,?)";

				statement = bancoDados.getConexao().prepareStatement(sqlCarro);

				statement.setInt(1, carro.get_id());
				statement.setInt(2, carro.get_qtdPortas());
				
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
			String sqlCarro = "DELETE FROM carro WHERE id_Aut=" + id;
			
			String sqlAutomovel = "DELETE FROM automovel WHERE id=" + id;

			PreparedStatement statement = bancoDados.getConexao().prepareStatement(sqlCarro);
			
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

	public int Editar(Carro carro) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE automovel SET");
		sql.append(" nome= '" + carro.get_nome() + "',");
		sql.append("quilometragem = " + carro.getQuilometragem() + ",");
		sql.append("qtdRodas = " + carro.get_qtdRodas() + ",");
		sql.append("cor = '" + carro.get_cor() + "',");
		sql.append("valor = " + carro.get_valor() + ",");
		sql.append("id_Categoria = " + carro.get_Categoria().getid_Categoria());
		sql.append(" WHERE id = " + carro.get_id());
		
		if(bancoDados.ExecutarDDL(sql.toString()) == 1) {
			
			sql = new StringBuilder();
			sql.append("UPDATE carro SET");
			sql.append(" qtdPortas = " + carro.get_qtdPortas());
			sql.append(" WHERE id_Aut = " + carro.get_id());	
			
			return bancoDados.ExecutarDDL(sql.toString());
		}
		else {
			return -2;
		}	
	}

	public Carro Carregar(int id) throws Exception {
		Carro carro = null;

		try {

			StringBuilder sql = new StringBuilder();
			sql.append(this.SelectCarro());
			sql.append(" where a.id =" + id);			

			ResultSet resultSet = bancoDados.ExecutarQuery(sql.toString());

			if (resultSet.next()) {
				carro = this.Preencher(resultSet);
			}			

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
			throw sqlEx;
		}

		return carro;
	}

	public Carro Preencher(ResultSet resultSet) throws Exception {
		
		return new Carro(resultSet.getInt("a.id"),
				resultSet.getString("a.nome"),
				resultSet.getInt("a.qtdRodas"),
				resultSet.getString("a.cor"),
				resultSet.getDouble("a.valor"), 
				new CategoriaDAO(bancoDados).Carregar(resultSet.getInt("a.id_Categoria")),
				resultSet.getDouble("a.quilometragem"),
				resultSet.getInt("c.qtdPortas"));
	}

	public List<Carro> Listar() throws Exception {
		List<Carro> carros = new ArrayList<Carro>();

		try 
		{
			StringBuilder sql = new StringBuilder();
			sql.append(this.SelectCarro());

			ResultSet resultSet = bancoDados.ExecutarQuery(sql.toString());

			if (resultSet.next()) {
				carros.add(this.Preencher(resultSet));
			}			

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
			throw sqlEx;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return carros;
	}
}
