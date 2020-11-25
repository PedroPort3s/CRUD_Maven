package entity;

public class Depreciacao {
	
	private double depreciacaoAoMes;
	private double valorFinalVeiculo;
	private Categoria categoria;	
	private double valorFinalReboque;
	private double valorDepreciado;
	
	public Depreciacao(double depreciacaoAoMes, double valorFinalVeiculo, Categoria categoria, double valorFinalReboque,
			double valorDepreciado) {
		super();
		this.depreciacaoAoMes = depreciacaoAoMes;
		this.valorFinalVeiculo = valorFinalVeiculo;
		this.categoria = categoria;
		this.valorFinalReboque = valorFinalReboque;
		this.valorDepreciado = valorDepreciado;
	}
	
	public Depreciacao() {
		
	}

	public double getDepreciacaoAoMes() {
		return depreciacaoAoMes;
	}

	public void setDepreciacaoAoMes(double depreciacaoAoMes) {
		this.depreciacaoAoMes = depreciacaoAoMes;
	}

	public double getValorFinalVeiculo() {
		return valorFinalVeiculo;
	}

	public void setValorFinalVeiculo(double valorFinalVeiculo) {
		this.valorFinalVeiculo = valorFinalVeiculo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public double getValorFinalReboque() {
		return valorFinalReboque;
	}

	public void setValorFinalReboque(double valorFinalReboque) {
		this.valorFinalReboque = valorFinalReboque;
	}

	public double getValorDepreciado() {
		return valorDepreciado;
	}

	public void setValorDepreciado(double valorDepreciado) {
		this.valorDepreciado = valorDepreciado;
	}
	
	
}
