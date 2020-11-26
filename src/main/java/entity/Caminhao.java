package entity;

import helper.Verifica;

public class Caminhao extends Automovel {

	public Caminhao(int _id, String _nome, int _qtdRodas, String _cor, double _valor, Categoria _Categoria,
			double quilometragem, int _qtdEixos, entity.Reboque reboque) {
		super(_id, _nome, _qtdRodas, _cor, _valor, _Categoria, quilometragem);
		this._qtdEixos = _qtdEixos;
		Reboque = reboque;
	}

	public Caminhao() {

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
	public String CalcularDepreciacaoGerencial(double valorFinal, int prazoAnos) {
		Categoria cat = this.get_Categoria();

		int meses = prazoAnos * 12;

		double depreciacaoMesCaminhao = (this.get_valor() - valorFinal) / meses;

		double valorDepreciadoCaminhao = depreciacaoMesCaminhao * meses;
		
		String depCaminhao = "Caminhão " + this.get_nome()+":\nDepreciação ao Mes: R$ " + Verifica.Arredondar(depreciacaoMesCaminhao, 2)  + "\nValor depreciado: R$ " + Verifica.Arredondar(valorDepreciadoCaminhao, 2) + " em "
				+ cat.getprazoDepreciacao() + " anos.";
		
		double depreciacaoMesReboque = (this.getReboque().getValorReboque() - (this.getReboque().getValorReboque() * (cat.getpercValorResidual()/100))) / meses;
		double valorDepreciadoReboque = depreciacaoMesReboque * meses;
		
		String depReboque = "Reboque " + this.getReboque().getNomeReboque()+":\nDepreciação ao Mes: R$ " + Verifica.Arredondar(depreciacaoMesReboque, 2)   + "\nValor depreciado: R$ " + Verifica.Arredondar(valorDepreciadoReboque, 2)  + " em "
				+ cat.getprazoDepreciacao() + " anos.";
				
		String depreciacaoTotal = "Depreciação total ao mes: R$ " + Verifica.Arredondar((depreciacaoMesCaminhao + depreciacaoMesReboque), 2)  + "\nValor total depreciado em " + prazoAnos +" anos: R$ "+Verifica.Arredondar((valorDepreciadoCaminhao+valorDepreciadoReboque), 2);

		return depCaminhao + "\n" + depReboque + "\n" + depreciacaoTotal; 
	}

	@Override
	public String CalcularDepreciacaoContabil() {
		Categoria cat = this.get_Categoria();

		double valorResidualCaminhao = this.get_valor() * (cat.getpercValorResidual() / 100);

		double depreciacaoMesesCaminhao = this.get_valor() / (cat.getprazoDepreciacao() * 12);

		double porcentagemDesvalorizacaoCaminhao = (valorResidualCaminhao / this.get_valor()) * 100;
		
		String depCaminhao = "Caminhão " + this.get_nome()+"\nDepreciação ao Mes: R$ " + Verifica.Arredondar(depreciacaoMesesCaminhao,2) + "\nValor residual após " + cat.getprazoDepreciacao()
		+ " anos: R$ " + Verifica.Arredondar(valorResidualCaminhao,2) + "\nDesvalorização de:" + Verifica.Arredondar(porcentagemDesvalorizacaoCaminhao,2) + "%";
		
		double valorResidualReboque = this.getReboque().getValorReboque() * (cat.getpercValorResidual() / 100);

		double depreciacaoMesesReboque = this.getReboque().getValorReboque() / (cat.getprazoDepreciacao() * 12);

		double porcentagemDesvalorizacaoReboque= (valorResidualCaminhao / this.get_valor()) * 100;
		
		String depReboque = "Reboque " + this.getReboque().getNomeReboque()+"\nDepreciação ao Mes: R$ " + Verifica.Arredondar(depreciacaoMesesReboque,2) + "\nValor residual após " + cat.getprazoDepreciacao()
		+ " anos: R$ " + Verifica.Arredondar(valorResidualReboque,2) + "\nDesvalorização de:" + Verifica.Arredondar(porcentagemDesvalorizacaoReboque,2) + "%";
		
		String depreciacaoTotal = "Depreciação total ao mes: R$ " + Verifica.Arredondar(depreciacaoMesesCaminhao + depreciacaoMesesReboque,2) + "\nValor total residual em" + cat.getprazoDepreciacao()+" anos: R$ "+Verifica.Arredondar((valorResidualCaminhao+valorResidualReboque),2);

		return depCaminhao + "\n" + depReboque + "\n" + depreciacaoTotal;
	}

	@Override
	public String toString() {
		return "Caminhao " + this.get_nome() + ", valor= " + Verifica.Arredondar(this.get_valor(),2) + ", Quilometragem= " + this.getQuilometragem();
	}
}
