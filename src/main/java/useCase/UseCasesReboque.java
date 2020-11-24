package useCase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.automovel.ReboqueDAO;
import entity.Reboque;
import interfaces.IBancoDados;

public class UseCasesReboque {

	private IBancoDados bancoDados;

	public UseCasesReboque(IBancoDados bancoDados) {
		this.bancoDados = bancoDados;
	}
	
	public int GravarReboque(Reboque reboque) throws Exception {
		int retorno = 0;

		try {
			bancoDados.ConectarBanco();
			bancoDados.ComecarTransacao(true);

			this.ValidarReboqueGravar(reboque);

			ReboqueDAO reboqueDAO = new ReboqueDAO(bancoDados);

			retorno = reboqueDAO.Inserir(reboque);

			if (retorno == 1) {
				bancoDados.CommitTransacao();
			} else {
				throw new Exception("Não foi possível gravar um novo reboque");
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
	
	
	public Reboque CarregarReboque(int id) throws Exception {
		Reboque reboque = null;

		try {
			bancoDados.ConectarBanco();

			if (id <= 0) {
				throw new Exception("Informe uma id válida para o reboque");
			}

			ReboqueDAO reboqueDAO = new ReboqueDAO(bancoDados);

			reboque = reboqueDAO.Carregar(id);

			if (reboque == null) {
				throw new Exception("Não foi possível carregar um reboque");
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

		return reboque;
	}

	public List<Reboque> ListarReboques() throws Exception {
		List<Reboque> reboques = new ArrayList<Reboque>();

		try {
			bancoDados.ConectarBanco();

			ReboqueDAO reboqueDAO = new ReboqueDAO(bancoDados);

			reboques = reboqueDAO.Listar();

			if (reboques == null) {
				throw new Exception("Não foi possível listar os reboques");
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

		return reboques;
	}
	
	private void ValidarReboqueGravar(Reboque reboque) throws Exception {
		if(reboque == null) throw new Exception("Reboque não informado");
		if(reboque.getNomeReboque().isEmpty()) throw new Exception("Informe o nome do reboque");
		if(reboque.getValorReboque() <= 1000) throw new Exception("Informe um valor acima de R$ 500,00 para o reboque.");
		if(reboque.getQuilometragem() < 0) throw new Exception("Informe uma quilometragem maior ou igual a zero");
	}

}
