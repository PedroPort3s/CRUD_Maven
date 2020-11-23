package dao.automovel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.categoria.CategoriaDAO;
import entity.Carro;
import interfaces.IBancoDados;
import interfaces.IPadraoCRUD;

public class CarroDAO implements IPadraoCRUD<Carro> {

	private IBancoDados bancoDados;

	public CarroDAO(IBancoDados bancoDados) {
		this.bancoDados = bancoDados;
	}

	private String SelectCarro() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT a.id, a.qtdRodas, a.cor, a.valor, a.id_Categoria, c.qtdPortas ");
		sql.append(" FROM automovel as a inner join carro as c on c.id_Aut = a.id;");
		return sql.toString();
	}

	public int Inserir(Carro obj) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int Deletar(int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int Editar(Carro obj) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public Carro Carregar(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Carro Preencher(ResultSet resultSet) throws Exception {
		
		return new Carro(resultSet.getInt("a.id"),
				resultSet.getInt("a.qtdRodas"),
				resultSet.getString("a.cor"),
				resultSet.getDouble("a.valor"), 
				new CategoriaDAO(bancoDados).Carregar(resultSet.getInt("a.id_Categoria")),
				resultSet.getInt("c.qtdPortas"));
	}

	public List<Carro> Listar() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
