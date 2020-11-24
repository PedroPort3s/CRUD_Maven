package entity;

public class Caminhao extends Automovel {
	
	public Caminhao(int _id, String _nome, int _qtdRodas, String _cor, double _valor, Categoria _Categoria,
			double quilometragem, int _qtdEixos, entity.Reboque reboque) {
		super(_id, _nome, _qtdRodas, _cor, _valor, _Categoria, quilometragem);
		this._qtdEixos = _qtdEixos;
		Reboque = reboque;
	}

	private int _qtdEixos;

	public int get_qtdEixos() {
		return _qtdEixos;
	}

	public void set_qtdEixos(int _qtdEixos) {
		this._qtdEixos = _qtdEixos;
	}

	private Reboque Reboque;

	public Reboque getReboque() {
		return Reboque;
	}

	public void setReboque(Reboque reboque) {
		Reboque = reboque;
	}

	@Override
	public Depreciacao CalcularDepreciacaoGerencial(double valorVenal, double valorFinal, int prazoAnos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Depreciacao CalcularDepreciacaoContabil(Categoria categoria) {
		// TODO Auto-generated method stub
		return null;
	}

}
