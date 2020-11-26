package entity;

public class Carro extends Automovel 
{
	public Carro(int _id, String _nome, int _qtdRodas, String _cor, double _valor, Categoria _Categoria,
			double quilometragem, int _qtdPortas) {
		super(_id, _nome, _qtdRodas, _cor, _valor, _Categoria, quilometragem);
		this._qtdPortas = _qtdPortas;
	}

	public Carro() {
		// TODO Auto-generated constructor stub
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
		Depreciacao dep = new Depreciacao();
		dep.setDepreciacaoAoMes((this.get_valor() - valorFinal) * (prazoAnos*12));
		return dep;
	}

	@Override
	public Depreciacao CalcularDepreciacaoContabil() {
		
		Depreciacao dep = new Depreciacao();
		
		Categoria cat =this.get_Categoria();
		
		double valorResidual = this.get_valor() * (cat.getpercValorResidual()/100);
		
		dep.setDepreciacaoAoMes(this.get_valor() / (cat.getprazoDepreciacao() * 12));
		
		return null;
	}

}
