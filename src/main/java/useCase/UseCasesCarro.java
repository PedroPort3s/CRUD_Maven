package useCase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.automovel.CarroDAO;
import entity.Carro;
import interfaces.IBancoDados;

public class UseCasesCarro {

	private IBancoDados bancoDados;

	public UseCasesCarro(IBancoDados bancoDados) {
		this.bancoDados = bancoDados;
	}
	
	public int GravarCarro(Carro carro) throws Exception {
		int retorno = 0;

		try {
			bancoDados.ConectarBanco();
			bancoDados.ComecarTransacao(true);

			this.ValidarCarroGravar(carro);

			CarroDAO carroDAO = new CarroDAO(bancoDados);

			retorno = carroDAO.Inserir(carro);

			if (retorno == 1) {
				bancoDados.CommitTransacao();
			} else {
				throw new Exception("Não foi possível gravar um novo carro");
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

	public int EditarCarro(Carro carro) throws Exception {
		int retorno = 0;

		try {
			bancoDados.ConectarBanco();
			bancoDados.ComecarTransacao(true);

			this.ValidarCarro(carro);

			CarroDAO carroDAO = new CarroDAO(bancoDados);

			retorno = carroDAO.Editar(carro);

			if (retorno == 2) {
				bancoDados.CommitTransacao();
			} else {
				throw new Exception("Não foi possível editar o carro");
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

	public int ExcluirCarro(Carro carro) throws Exception {
		int retorno = 0;

		try {
			bancoDados.ConectarBanco();
			bancoDados.ComecarTransacao(true);

			this.ValidarCarro(carro);

			CarroDAO carroDAO = new CarroDAO(bancoDados);

			retorno = carroDAO.Deletar(carro.get_id());

			if (retorno == 1) {
				bancoDados.CommitTransacao();
			} else {
				throw new Exception("Não foi possível excluir o carro");
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

	public Carro CarregarCarro(int id) throws Exception {
		Carro carro = null;

		try {
			bancoDados.ConectarBanco();

			if (id <= 0) {
				throw new Exception("Informe uma id válida para o carro");
			}

			CarroDAO carroDAO = new CarroDAO(bancoDados);

			carro = carroDAO.Carregar(id);

			if (carro == null) {
				throw new Exception("Não foi possível carregar um carro");
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

		return carro;
	}

	public List<Carro> ListarCarros() throws Exception {
		List<Carro> carros = new ArrayList<Carro>();

		try {
			bancoDados.ConectarBanco();

			CarroDAO carroDAO = new CarroDAO(bancoDados);

			carros = carroDAO.Listar();

			if (carros == null) {
				throw new Exception("Não foi possível listar os carros");
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

		return carros;
	}
	
	private void ValidarCarro(Carro carro) throws Exception {
		if(carro == null) throw new Exception("Carro não informado");
		if(carro.get_id() <= 0) throw new Exception("Informe uma id válida para o carro");
		if(carro.get_nome().isEmpty()) throw new Exception("Informe o nome do carro");
		if(carro.get_qtdPortas() != 2 && carro.get_qtdPortas() != 3 &&  carro.get_qtdPortas() != 4) throw new Exception("Informe uma quantidade de portas válida");
		if(carro.get_cor().isEmpty()) throw new Exception("Informe a cor do carro");
		if(carro.get_qtdRodas() != 4 && carro.get_qtdRodas() != 6) throw new Exception("Informe a uma quantidade de rodas válida");
		if(carro.get_valor() <= 1000) throw new Exception("Informe um valor acima de R$ 1000,00 para o carro.");
		if(carro.getQuilometragem() < 0) throw new Exception("Informe uma quilometragem maior ou igual a zero");
		if(carro.get_Categoria() == null) throw new Exception("Informe a categoria a qual o carro pertence");
		if(carro.get_Categoria().getid_Categoria() <= 0) throw new Exception("Informe uma id válida para a categoria");
	}
	
	private void ValidarCarroGravar(Carro carro) throws Exception {
		if(carro == null) throw new Exception("Carro não informado");
		if(carro.get_nome().isEmpty()) throw new Exception("Informe o nome do carro");
		if(carro.get_qtdPortas() != 2 && carro.get_qtdPortas() != 3 &&  carro.get_qtdPortas() != 4) throw new Exception("Informe uma quantidade de portas válida");
		if(carro.get_cor().isEmpty()) throw new Exception("Informe a cor do carro");
		if(carro.get_qtdRodas() != 4 && carro.get_qtdRodas() != 6) throw new Exception("Informe a uma quantidade de rodas válida");
		if(carro.get_valor() <= 1000) throw new Exception("Informe um valor acima de R$ 1000,00 para o carro.");
		if(carro.getQuilometragem() < 0) throw new Exception("Informe uma quilometragem maior ou igual a zero");
		if(carro.get_Categoria() == null) throw new Exception("Informe a categoria a qual o carro pertence");
		if(carro.get_Categoria().getid_Categoria() <= 0) throw new Exception("Informe uma id válida para a categoria");
	}

}
