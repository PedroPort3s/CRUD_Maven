package controle;

import java.util.List;

import dao.DbMySql;
import entity.Carro;
import useCase.UseCasesCarro;

public class ControlCarro {

	public ControlCarro() {
		// TODO Auto-generated constructor stub
	}

	public int GravarCarro(Carro carro) throws Exception {
		int retorno = 0;

		UseCasesCarro UseCaseCarro = new UseCasesCarro(new DbMySql());
		try {

			if (carro != null && carro.get_id() > 0) {
				retorno = UseCaseCarro.EditarCarro(carro);
			} else {
				retorno = UseCaseCarro.GravarCarro(carro);
			}
		} catch (Exception e) {
			throw e;
		}

		return retorno;
	}

	public int ExcluirCarro(Carro carro) throws Exception {
		int retorno = 0;

		UseCasesCarro UseCaseCarro = new UseCasesCarro(new DbMySql());
		try {
			retorno = UseCaseCarro.ExcluirCarro(carro);

		} catch (Exception e) {
			throw e;
		}

		return retorno;
	}

	public Carro CarregarCarro(int id) throws Exception {
		Carro carro = null;

		UseCasesCarro UseCaseCarro = new UseCasesCarro(new DbMySql());
		try {
			carro = UseCaseCarro.CarregarCarro(id);
		} catch (Exception e) {
			throw e;
		}

		return carro;
	}

	public List<Carro> ListarCarros() throws Exception {
		List<Carro> carros = null;

		UseCasesCarro UseCaseCarro = new UseCasesCarro(new DbMySql());
		try {
			carros = UseCaseCarro.ListarCarros();
		} catch (Exception e) {
			throw e;
		}

		return carros;
	}

}
