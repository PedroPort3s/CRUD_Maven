package entity;

public abstract class Automovel {
	private int _id;

	public int get_id() {
		return this._id;
	}

	public void set_id(int value) {
		this._id = value;
	}

	private int _qtdRodas;

	public int get_qtdRodas() {
		return this._qtdRodas;
	}

	public void set_qtdRodas(int value) {
		this._qtdRodas = value;
	}

	private String _cor;

	public String get_cor() {
		return this._cor;
	}

	public void set_cor(String value) {
		this._cor = value;
	}

	private double _valor;

	public double get_valor() {
		return this._valor;
	}

	public void set_valor(double value) {
		this._valor = value;
	}

	private Categoria _Categoria;

	public Categoria get_Categoria() {
		return this._Categoria;
	}

	public void set_Categoria(Categoria categoria) {
		this._Categoria = categoria;
	}
	
	private double quilometragem;
	public double getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(double quilometragem) {
		this.quilometragem = quilometragem;
	}

	

	public Automovel(int id_, int qtdRodas_, String cor_, double valor_, Categoria Categoria_) {
		this._id = id_;
		this._qtdRodas = qtdRodas_;
		this._cor = cor_;
		this._valor = valor_;
		this._Categoria = Categoria_;
	}
	
	public abstract Depreciacao CalcularDepreciacaoGerencial(double valorVenal, double valorFinal, int prazoAnos);
	
	public abstract Depreciacao CalcularDepreciacaoContabil(Categoria categoria);
}
