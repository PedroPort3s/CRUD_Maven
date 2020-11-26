package controle;

import java.util.List;

import dao.DbMySql;
import entity.Reboque;
import useCase.UseCasesReboque;

public class ControlReboque {

	public ControlReboque() {
		// TODO Auto-generated constructor stub
	}
	
	public int GravarReboque(Reboque reboque) throws Exception {
		int retorno = 0;

		UseCasesReboque UseCaseReboque = new UseCasesReboque(new DbMySql());
		try {
				retorno = UseCaseReboque.GravarReboque(reboque);
			
		} catch (Exception e) {
			throw e;
		}

		return retorno;
	}

	public Reboque CarregarReboque(int id) throws Exception {
		Reboque reboque = null;

		UseCasesReboque UseCaseReboque = new UseCasesReboque(new DbMySql());
		try {
			reboque = UseCaseReboque.CarregarReboque(id);
		} catch (Exception e) {
			throw e;
		}

		return reboque;
	}

	public List<Reboque> ListarReboques() throws Exception {
		List<Reboque> caminhoes = null;

		UseCasesReboque UseCaseReboque = new UseCasesReboque(new DbMySql());
		try {
			caminhoes = UseCaseReboque.ListarReboques();
		} catch (Exception e) {
			throw e;
		}

		return caminhoes;
	}

}
