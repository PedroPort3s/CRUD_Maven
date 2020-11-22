package entity;

public class Depreciacao {
	
	private double valorVenal;
	private double valorFinal;
	private int prazoAnos;
	
	public Depreciacao() {
		
	}

	public Depreciacao(double valorVenal, double valorFinal, int prazoAnos) {
		super();
		this.valorVenal = valorVenal;
		this.valorFinal = valorFinal;
		this.prazoAnos = prazoAnos;
	}

	public double getValorVenal() {
		return valorVenal;
	}

	public void setValorVenal(double valorVenal) {
		this.valorVenal = valorVenal;
	}

	public double getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(double valorFinal) {
		this.valorFinal = valorFinal;
	}

	public int getPrazoAnos() {
		return prazoAnos;
	}

	public void setPrazoAnos(int prazoAnos) {
		this.prazoAnos = prazoAnos;
	}

}
