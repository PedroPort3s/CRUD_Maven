package useCase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.automovel.CaminhaoDAO;
import entity.Caminhao;
import interfaces.IBancoDados;

public class UseCasesCaminhao {

	private IBancoDados bancoDados;

	public UseCasesCaminhao(IBancoDados bancoDados) {
		this.bancoDados = bancoDados;
	}
	
	public int GravarCaminhao(Caminhao caminhao) throws Exception {
		int retorno = 0;

		try {
			bancoDados.ConectarBanco();
			bancoDados.ComecarTransacao(true);

			this.ValidarCaminhaoGravar(caminhao);

			CaminhaoDAO caminhaoDAO = new CaminhaoDAO(bancoDados);

			retorno = caminhaoDAO.Inserir(caminhao);

			if (retorno == 1) {
				bancoDados.CommitTransacao();
			} else {
				throw new Exception("Não foi possível gravar um novo caminhao");
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

	public int EditarCaminhao(Caminhao caminhao) throws Exception {
		int retorno = 0;

		try {
			bancoDados.ConectarBanco();
			bancoDados.ComecarTransacao(true);

			this.ValidarCaminhao(caminhao);

			CaminhaoDAO caminhaoDAO = new CaminhaoDAO(bancoDados);

			retorno = caminhaoDAO.Editar(caminhao);

			if (retorno == 2) {
				bancoDados.CommitTransacao();
			} else {
				throw new Exception("Não foi possível editar o caminhao");
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

	public int ExcluirCaminhao(Caminhao caminhao) throws Exception {
		int retorno = 0;

		try {
			bancoDados.ConectarBanco();
			bancoDados.ComecarTransacao(true);

			this.ValidarCaminhao(caminhao);

			CaminhaoDAO caminhaoDAO = new CaminhaoDAO(bancoDados);

			retorno = caminhaoDAO.Deletar(caminhao.get_id());

			if (retorno == 1) {
				bancoDados.CommitTransacao();
			} else {
				throw new Exception("Não foi possível excluir o caminhao");
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

	public Caminhao CarregarCaminhao(int id) throws Exception {
		Caminhao caminhao = null;

		try {
			bancoDados.ConectarBanco();

			if (id <= 0) {
				throw new Exception("Informe uma id válida para o caminhao");
			}

			CaminhaoDAO caminhaoDAO = new CaminhaoDAO(bancoDados);

			caminhao = caminhaoDAO.Carregar(id);

			if (caminhao == null) {
				throw new Exception("Não foi possível carregar um caminhao");
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

		return caminhao;
	}

	public List<Caminhao> ListarCaminhoes() throws Exception {
		List<Caminhao> caminhaos = new ArrayList<Caminhao>();

		try {
			bancoDados.ConectarBanco();

			CaminhaoDAO caminhaoDAO = new CaminhaoDAO(bancoDados);

			caminhaos = caminhaoDAO.Listar();

			if (caminhaos == null) {
				throw new Exception("Não foi possível listar os caminhoes");
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

		return caminhaos;
	}
	
	private void ValidarCaminhao(Caminhao caminhao) throws Exception {
		if(caminhao == null) throw new Exception("Caminhao não informado");
		if(caminhao.get_id() <= 0) throw new Exception("Informe uma id válida para o caminhao");
		if(caminhao.get_nome().isEmpty()) throw new Exception("Informe o nome do caminhao");
		if(caminhao.getReboque() == null || caminhao.getReboque().getId() <= 0) throw new Exception("Informe um reboque para o caminhao");
		if(caminhao.get_cor().isEmpty()) throw new Exception("Informe a cor do caminhao");
		if(caminhao.get_qtdRodas() != 4 || caminhao.get_qtdRodas() != 6) throw new Exception("Informe a uma quantiade de rodas válida");
		if(caminhao.get_valor() <= 1000) throw new Exception("Informe um valor acima de R$ 1000,00 para o caminhao.");
		if(caminhao.getQuilometragem() < 0) throw new Exception("Informe uma quilometragem maior ou igual a zero");
		if(caminhao.get_Categoria() == null) throw new Exception("Informe a categoria a qual o caminhao pertence");
		if(caminhao.get_Categoria().getid_Categoria() <= 0) throw new Exception("Informe uma id válida para a categoria");
	}
	
	private void ValidarCaminhaoGravar(Caminhao caminhao) throws Exception {
		if(caminhao == null) throw new Exception("Caminhao não informado");
		if(caminhao.get_nome().isEmpty()) throw new Exception("Informe o nome do caminhao");
		if(caminhao.getReboque() == null || caminhao.getReboque().getId() <= 0) throw new Exception("Informe um reboque para o caminhao");
		if(caminhao.get_cor().isEmpty()) throw new Exception("Informe a cor do caminhao");
		if(caminhao.get_qtdRodas() != 4 || caminhao.get_qtdRodas() != 6) throw new Exception("Informe a uma quantiade de rodas válida");
		if(caminhao.get_valor() <= 1000) throw new Exception("Informe um valor acima de R$ 1000,00 para o caminhao.");
		if(caminhao.getQuilometragem() < 0) throw new Exception("Informe uma quilometragem maior ou igual a zero");
		if(caminhao.get_Categoria() == null) throw new Exception("Informe a categoria a qual o caminhao pertence");
		if(caminhao.get_Categoria().getid_Categoria() <= 0) throw new Exception("Informe uma id válida para a categoria");
	}

}
