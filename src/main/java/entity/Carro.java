package entity;

public class Carro extends Automovel 
{
	public Carro(int _id, String _nome, int _qtdRodas, String _cor, double _valor, Categoria _Categoria,
			double quilometragem, int _qtdPortas) {
		super(_id, _nome, _qtdRodas, _cor, _valor, _Categoria, quilometragem);
		this._qtdPortas = _qtdPortas;
	}

	private int _qtdPortas;	

	public int get_qtdPortas() {
		return _qtdPortas;
	}

	public void set_qtdPortas(int _qtdPortas) {
		this._qtdPortas = _qtdPortas;
	}

	@Override
	public Depreciacao CalcularDepreciacaoGerencial(double valorFinal, int prazoAnos) {
		
		Depreciacao dep = new Depreciacao(this.get_valor(),valorFinal,prazoAnos);

		return ;
	}

	@Override
	public Depreciacao CalcularDepreciacaoContabil() {
		// TODO Auto-generated method stub
		return null;
	}

}
