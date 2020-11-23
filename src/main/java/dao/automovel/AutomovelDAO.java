package dao.automovel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import entity.Automovel;
import interfaces.IBancoDados;
import interfaces.IPadraoCRUD;

public class AutomovelDAO implements IPadraoCRUD<Automovel> {

	private IBancoDados bancoDados;
	
	public AutomovelDAO(IBancoDados bancoDados) {
		this.bancoDados = bancoDados;
	}

	public int Inserir(Automovel obj) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int Deletar(int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int Editar(Automovel obj) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public Automovel Carregar(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Automovel Preencher(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Automovel> Listar() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
