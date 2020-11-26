package entity;

import helper.Verifica;

public class Carro extends Automovel 
{
	public Carro(int _id, String _nome, int _qtdRodas, String _cor, double _valor, Categoria _Categoria,
			double quilometragem, int _qtdPortas) {
		super(_id, _nome, _qtdRodas, _cor, _valor, _Categoria, quilometragem);
		this._qtdPortas = _qtdPortas;
	}

	public Carro() {
		
	}

	private int _qtdPortas;	

	public int get_qtdPortas() {
		return _qtdPortas;
	}

	public void set_qtdPortas(int _qtdPortas) {
		this._qtdPortas = _qtdPortas;
	}

	@Override
	public String CalcularDepreciacaoGerencial(double valorFinal, int prazoAnos) {
		
		Categoria cat = this.get_Categoria();
		
		int meses = prazoAnos * 12;
		
		double depreciacaoMes = (this.get_valor() - valorFinal) / meses;
		
		double valorDepreciado = depreciacaoMes * meses;
		
		return "Depreciação ao Mes: R$ "+ Verifica.Arredondar(depreciacaoMes,2) + "\nValor depreciado: R$ "+ Verifica.Arredondar(valorDepreciado,2)+" em "+ cat.getprazoDepreciacao() +" anos.";
	}

	@Override
	public String CalcularDepreciacaoContabil() {
		
		Categoria cat = this.get_Categoria();
		
		double valorResidual = this.get_valor() * (cat.getpercValorResidual() / 100);
		
		double depreciacaoMeses = this.get_valor() / (cat.getprazoDepreciacao() * 12);
		
		double porcentagemDesvalorizacao = (valorResidual/this.get_valor()) * 100;
		
		return "Depreciação ao Mes: R$ "+ Verifica.Arredondar(depreciacaoMeses,2) + "\nValor residual após " +cat.getprazoDepreciacao() + " anos: R$ "+Verifica.Arredondar(valorResidual,2)+"\n Desvalorização de:" + Verifica.Arredondar(porcentagemDesvalorizacao,2) + "%";
	}

	@Override
	public String toString() {
		return "Carro " + this.get_nome() + ", valor= " + this.get_qtdRodas() + ", Quilometragem= " + this.getQuilometragem();
	}
}
