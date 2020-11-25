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
	public Depreciacao CalcularDepreciacaoGerencial(double valorFinal, int prazoAnos) {
		Depreciacao dep = new Depreciacao();
		dep.setDepreciacaoAoMes((this.get_valor() - valorFinal) * (prazoAnos * 12));
		return dep;
	}

	@Override
	public Depreciacao CalcularDepreciacaoContabil() {
		Depreciacao dep = new Depreciacao();

		Categoria cat = this.get_Categoria();

		double valorResidual = this.get_valor() * (cat.getpercValorResidual() / 100);

		dep.setDepreciacaoAoMes(this.get_valor() / (cat.getprazoDepreciacao() * 12));

		return null;
	}

}
