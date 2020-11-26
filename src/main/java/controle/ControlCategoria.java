package controle;

import java.util.List;

import dao.DbMySql;
import entity.Categoria;
import useCase.UseCasesCategoria;

public class ControlCategoria {

	public ControlCategoria() {

	}
	
	public int GravarCategoria(Categoria categoria) throws Exception {
		int retorno = 0;
		
		UseCasesCategoria useCaseCat = new UseCasesCategoria(new DbMySql());
		try {
			
			if(categoria != null && categoria.getid_Categoria() > 0) {
				retorno = useCaseCat.EditarCategoria(categoria);	
			}
			else {
				retorno = useCaseCat.GravarCategoria(categoria);	
			}
		} catch (Exception e) {
			throw e;
		}
		
		return retorno;
	}
	
	public int ExcluirCategoria(Categoria categoria) throws Exception {
		int retorno = 0;
		
		UseCasesCategoria useCaseCat = new UseCasesCategoria(new DbMySql());
		try {
				retorno = useCaseCat.ExcluirCategoria(categoria);	
			
		} catch (Exception e) {
			throw e;
		}
		
		return retorno;
	}
	
	public Categoria CarregarCategoria(int id) throws Exception {
		Categoria categoria = null;
		
		UseCasesCategoria useCaseCat = new UseCasesCategoria(new DbMySql());
		try {
			categoria = useCaseCat.CarregarCategoria(id);
		} catch (Exception e) {
			throw e;
		}
		
		return categoria;
	}
	
	public List<Categoria> ListarCategorias() throws Exception {
		List<Categoria> categorias = null;
		
		UseCasesCategoria useCaseCat = new UseCasesCategoria(new DbMySql());
		try {
			categorias = useCaseCat.ListarCategorias();
		} catch (Exception e) {
			throw e;
		}
		
		return categorias;
	}
}
