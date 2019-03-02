package teste;

public class Facilitadores {
	private int idfacilitador;
	private String nome;
	private String endereco;
	private double pagamento;
	
	public Facilitadores(int idfacilitador, String nome, String endereco, double pagamento) {
		this.idfacilitador = idfacilitador;
		this.nome = nome;
		this.endereco = endereco;
		this.pagamento = pagamento;
	}
	
	public int getIdfacilitador() {
		return idfacilitador;
	}
	public void setIdfacilitador(int idfacilitador) {
		this.idfacilitador = idfacilitador;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public double getPagamento() {
		return pagamento;
	}
	public void setPagamento(double pagamento) {
		this.pagamento = pagamento;
	}
}