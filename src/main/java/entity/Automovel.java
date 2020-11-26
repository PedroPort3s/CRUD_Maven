package entity;

public abstract class Automovel {
	
	public Automovel() {
			
	}
	
	public Automovel(int _id, String _nome, int _qtdRodas, String _cor, double _valor, Categoria _Categoria,
			double quilometragem) {
		super();
		this._id = _id;
		this._nome = _nome;
		this._qtdRodas = _qtdRodas;
		this._cor = _cor;
		this._valor = _valor;
		this._Categoria = _Categoria;
		this.quilometragem = quilometragem;
	}
	
	private int _id;

	public int get_id() {
		return this._id;
	}

	public void set_id(int value) {
		this._id = value;
	}
	
	private String _nome;

	public String get_nome() {
		return _nome;
	}

	public void set_nome(String _nome) {
		this._nome = _nome;
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
	
	public abstract String CalcularDepreciacaoGerencial(double valorFinal);
	
	public abstract String CalcularDepreciacaoContabil();

	@Override
	public String toString() {
		return "Automovel id=" + _id + ", nome=" + _nome + ", cor=" + _cor + ", valor=" + _valor + ", Categoria="
				+ _Categoria + ", quilometragem=" + quilometragem;
	}
	
	
}
