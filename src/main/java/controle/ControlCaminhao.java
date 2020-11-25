package controle;

import java.util.List;

import dao.DbMySql;
import entity.Caminhao;
import useCase.UseCasesCaminhao;

public class ControlCaminhao {

	public ControlCaminhao() {

	}
	
	public int GravarCaminhao(Caminhao caminhao) throws Exception {
		int retorno = 0;

		UseCasesCaminhao UseCaseCaminhao = new UseCasesCaminhao(new DbMySql());
		try {

			if (caminhao != null && caminhao.get_id() > 0) {
				retorno = UseCaseCaminhao.EditarCaminhao(caminhao);
			} else {
				retorno = UseCaseCaminhao.GravarCaminhao(caminhao);
			}
		} catch (Exception e) {
			throw e;
		}

		return retorno;
	}

	public int ExcluirCaminhao(Caminhao caminhao) throws Exception {
		int retorno = 0;

		UseCasesCaminhao UseCaseCaminhao = new UseCasesCaminhao(new DbMySql());
		try {
			retorno = UseCaseCaminhao.ExcluirCaminhao(caminhao);

		} catch (Exception e) {
			throw e;
		}

		return retorno;
	}

	public Caminhao CarregarCaminhao(int id) throws Exception {
		Caminhao caminhao = null;

		UseCasesCaminhao UseCaseCaminhao = new UseCasesCaminhao(new DbMySql());
		try {
			caminhao = UseCaseCaminhao.CarregarCaminhao(id);
		} catch (Exception e) {
			throw e;
		}

		return caminhao;
	}

	public List<Caminhao> ListarCaminhoes() throws Exception {
		List<Caminhao> caminhoes = null;

		UseCasesCaminhao UseCaseCaminhao = new UseCasesCaminhao(new DbMySql());
		try {
			caminhoes = UseCaseCaminhao.ListarCaminhoes();
		} catch (Exception e) {
			throw e;
		}

		return caminhoes;
	}

}
