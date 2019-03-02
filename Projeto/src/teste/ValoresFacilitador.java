package teste;

public class ValoresFacilitador {
	private int idFacilitador;
	private double valorDuvida;
	private double valorSimulado;	
	
	public ValoresFacilitador(int idFacilitador, double valorDuvida, double valorSimulado) {
		this.idFacilitador = idFacilitador;
		this.valorDuvida = valorDuvida;
		this.valorSimulado = valorSimulado;
	}
	public int getIdFacilitador() {
		return idFacilitador;
	}
	public void setIdFacilitador(int idFacilitador) {
		this.idFacilitador = idFacilitador;
	}
	public double getValorDuvida() {
		return valorDuvida;
	}
	public void setValorDuvida(double valorDuvida) {
		this.valorDuvida = valorDuvida;
	}
	public double getValorSimulado() {
		return valorSimulado;
	}
	public void setValorSimulado(double valorSimulado) {
		this.valorSimulado = valorSimulado;
	}
}
