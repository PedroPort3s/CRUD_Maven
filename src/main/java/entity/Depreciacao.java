package entity;

public class Depreciacao {
	
	private double depreciacaoAoMes;
	private double valorFinal;
	private Categoria categoria;
	
	public Depreciacao() {
		
	}

	public Depreciacao(double valorVenal, double valorFinal, int prazoAnos) {
		super();
		this.depreciacaoAoMes = ((valorVenal - valorFinal) * (prazoAnos * 12));
	}
	
	public Depreciacao(Automovel aut, Categoria cat) {
		this.categoria = cat;
		aut.get_valor();
		categoria.getprazoDepreciacao();
		categoria.getpercValorResidual();
		categoria.gettaxaDepreciacao();
	}

	public double getValorFinal() {
		return valorFinal;
	}
	
	public double getDepreciacaoAoMes() {
		return depreciacaoAoMes;
	}
	
	public double
}
