package entity;

public class Reboque {

	public Reboque() {
		// TODO Auto-generated constructor stub
	}
	
	public Reboque(double id, double quilometragem) {
		super();
		this.id = id;
		this.quilometragem = quilometragem;
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

}
