package entity;

public class Caminhao extends Automovel {

	private int _qtdEixos;

	public Caminhao(int id_, int qtdRodas_, String cor_, double valor_, Categoria Categoria_) {
		super(id_, qtdRodas_, cor_, valor_, Categoria_);
	}

	public Caminhao(int id_, int qtdRodas_, String cor_, double valor_, Categoria Categoria_, int qtdEixos_) {
		super(id_, qtdRodas_, cor_, valor_, Categoria_);
		this._qtdEixos = qtdEixos_;
	}

	public Caminhao(int id_, int qtdRodas_, String cor_, double valor_, Categoria Categoria_, int _qtdEixos,
			entity.Reboque reboque) {
		super(id_, qtdRodas_, cor_, valor_, Categoria_);
		this._qtdEixos = _qtdEixos;
		Reboque = reboque;
	}

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
