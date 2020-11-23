package entity;

public class Reboque {

	public Reboque() {

	}
	
	public Reboque(double id, double quilometragem) {
		super();
		this.id = id;
		this.quilometragem = quilometragem;
	}

	public Reboque(double id, double quilometragem, double valorReboque) {
		super();
		this.id = id;
		this.quilometragem = quilometragem;
		this.valorReboque = valorReboque;
	}

	private double id;
	public double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = id;
	}

	private double quilometragem;
	public double getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(double quilometragem) {
		this.quilometragem = quilometragem;
	}
	
	private double valorReboque;
	public double getValorReboque() {
		return valorReboque;
	}

	public void setValorReboque(double valorReboque) {
		this.valorReboque = valorReboque;
	}
}
