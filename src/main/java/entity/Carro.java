package entity;

public class Carro extends Automovel {
	
	private int _qtdPortas;

	public Carro(int id_, int qtdRodas_, String cor_, double valor_, Categoria Categoria_) {
		super(id_, qtdRodas_, cor_, valor_, Categoria_);
	}
	
	public Carro(int id_, int qtdRodas_, String cor_, double valor_, Categoria Categoria_, int qtdPortas_) {
		super(id_, qtdRodas_, cor_, valor_, Categoria_);
		this._qtdPortas = qtdPortas_;
	}

	public int get_qtdPortas() {
		return _qtdPortas;
	}

	public void set_qtdPortas(int _qtdPortas) {
		this._qtdPortas = _qtdPortas;
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
