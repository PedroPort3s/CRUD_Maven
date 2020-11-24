package useCase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.categoria.CategoriaDAO;
import entity.Categoria;
import interfaces.IBancoDados;

public class UseCasesCategoria {

	private IBancoDados bancoDados;

	public UseCasesCategoria(IBancoDados bancoDados) {
		this.bancoDados = bancoDados;
	}

	public int GravarCategoria(Categoria categoria) throws Exception {
		int retorno = 0;

		try {
			bancoDados.ConectarBanco();
			bancoDados.ComecarTransacao(true);

			this.ValidarCategoriaGravar(categoria);

			CategoriaDAO catDAO = new CategoriaDAO(bancoDados);

			retorno = catDAO.Inserir(categoria);

			if (retorno == 1) {
				bancoDados.CommitTransacao();
			} else {
				throw new Exception("N�o foi poss�vel gravar uma categoria");
			}
		} catch (SQLException e) {
			bancoDados.RollbackTransacao();
			System.out.println(e.getMessage());
			throw e;
		} catch (Exception e) {
			bancoDados.RollbackTransacao();
			e.printStackTrace();
			throw e;
		}
		finally {
			bancoDados.DesconectarBanco();
		}

		return retorno;
	}

	public int EditarCategoria(Categoria categoria) throws Exception {
		int retorno = 0;

		try {
			bancoDados.ConectarBanco();
			bancoDados.ComecarTransacao(true);

			this.ValidarCategoria(categoria);

			CategoriaDAO catDAO = new CategoriaDAO(bancoDados);

			retorno = catDAO.Editar(categoria);

			if (retorno == 2) {
				bancoDados.CommitTransacao();
			} else {
				throw new Exception("N�o foi poss�vel editar uma categoria");
			}
		} catch (SQLException e) {
			bancoDados.RollbackTransacao();
			System.out.println(e.getMessage());
			throw e;
		} catch (Exception e) {
			bancoDados.RollbackTransacao();
			e.printStackTrace();
			throw e;
		}
		finally {
			bancoDados.DesconectarBanco();
		}

		return retorno;
	}

	public int ExcluirCategoria(Categoria categoria) throws Exception {
		int retorno = 0;

		try {
			bancoDados.ConectarBanco();
			bancoDados.ComecarTransacao(true);

			this.ValidarCategoria(categoria);

			CategoriaDAO catDAO = new CategoriaDAO(bancoDados);

			retorno = catDAO.Deletar(categoria.getid_Categoria());

			if (retorno == 1) {
				bancoDados.CommitTransacao();
			} else {
				throw new Exception("N�o foi poss�vel excluir uma categoria");
			}
		} catch (SQLException e) {
			bancoDados.RollbackTransacao();
			System.out.println(e.getMessage());
			throw e;
		} catch (Exception e) {
			bancoDados.RollbackTransacao();
			e.printStackTrace();
			throw e;
		}
		finally {
			bancoDados.DesconectarBanco();
		}

		return retorno;
	}

	public Categoria CarregarCategoria(int id) throws Exception {
		Categoria categoria = null;

		try {
			bancoDados.ConectarBanco();

			if (id <= 0) {
				throw new Exception("Informe uma id v�lida para a categoria");
			}

			CategoriaDAO catDAO = new CategoriaDAO(bancoDados);

			categoria = catDAO.Carregar(id);

			if (categoria == null) {
				throw new Exception("N�o foi poss�vel carregar uma categoria");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			bancoDados.DesconectarBanco();
		}

		return categoria;
	}

	public List<Categoria> ListarCategorias() throws Exception {
		List<Categoria> categorias = new ArrayList<Categoria>();

		try {
			bancoDados.ConectarBanco();

			CategoriaDAO catDAO = new CategoriaDAO(bancoDados);

			categorias = catDAO.Listar();

			if (categorias == null) {
				throw new Exception("N�o foi poss�vel listar as categorias");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw e;
		} catch (Exception e) {
			throw e;
		}
		finally {
			bancoDados.DesconectarBanco();
		}

		return categorias;
	}

	private void ValidarCategoriaGravar(Categoria categoria) throws Exception {
		if (categoria.getnome().equals("")) {
			throw new Exception("Informe um nome para a categoria");
		}

		if (categoria.getnome().length() < 5) {
			throw new Exception("Informe um nome de ao menos 5 caracters para a categoria");
		}

		if (categoria.getpercValorResidual() >= 50) {
			throw new Exception("O valor residual n�o pode exceder 50% do valor do autom�vel");
		}

		if (categoria.getpercValorResidual() <= 0) {
			throw new Exception("O valor residual n�o pode ser menor ou igual a zero");
		}

		if (categoria.getprazoDepreciacao() <= 0) {
			throw new Exception("Informe o prazo em anos para os calculos de deprecia��o");
		}

		if (categoria.gettaxaDepreciacao() >= 50) {
			throw new Exception("A taxa de deprecia��o ao ano n�o deve exceder 50% do valor do ve�culo");
		}

		if (categoria.gettaxaDepreciacao() <= 0) {
			throw new Exception("Informe a taxa de deprecia��o ao ano");
		}
	}

	private void ValidarCategoria(Categoria categoria) throws Exception {

		if (categoria == null) {
			throw new Exception("Categoria n�o informada.");
		}

		this.ValidarCategoriaGravar(categoria);
	}
}
