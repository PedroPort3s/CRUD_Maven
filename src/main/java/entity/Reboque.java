package entity;

public class Reboque {

	public Reboque() {

	}



	public Reboque(int id, String nomeReboque, double quilometragem, double valorReboque) {
		super();
		this.id = id;
		this.quilometragem = quilometragem;
		this.valorReboque = valorReboque;
		this.nomeReboque = nomeReboque;
	}



	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
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
	
	private String nomeReboque;
	public String getNomeReboque() {
		return nomeReboque;
	}

	public void setNomeReboque(String nomeReboque) {
		this.nomeReboque = nomeReboque;
	}

	
}
