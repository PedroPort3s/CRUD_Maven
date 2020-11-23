package dao.automovel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import entity.Caminhao;
import interfaces.IBancoDados;
import interfaces.IPadraoCRUD;

public class CaminhaoDAO implements IPadraoCRUD<Caminhao> {

	private IBancoDados bancoDados;
	
	public CaminhaoDAO(IBancoDados bancoDados) {
		this.bancoDados = bancoDados;
	}
	
	private String Select_Caminhao() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT a.id, a.qtdRodas, a.cor, a.valor, a.id_Categoria, c.qtdEixos ");
		sql.append(" FROM automovel as a inner join caminhao as c on c.id_Aut = a.id");
		return sql.toString();
	}

	public int Inserir(Caminhao obj) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int Deletar(int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int Editar(Caminhao obj) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public Caminhao Carregar(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Caminhao Preencher(ResultSet resultSet) throws SQLException {
		return new Caminhao();
	}

	public List<Caminhao> Listar() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
