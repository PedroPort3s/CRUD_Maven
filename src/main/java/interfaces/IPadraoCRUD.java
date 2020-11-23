package interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import entity.Categoria;

public interface IPadraoCRUD<T> {

	public int Inserir(T obj) throws SQLException, ClassNotFoundException;

	public int Deletar(int id) throws SQLException;

	public int Editar(T obj) throws SQLException;

	public T Carregar(int id) throws Exception;

	public T Preencher(ResultSet resultSet) throws SQLException, Exception;

	public List<T> Listar() throws SQLException;
}
