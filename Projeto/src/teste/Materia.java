package teste;

public class Materia {
	
	private int codigo;
	private String nomeMateria;
	private int creditos;
	private double valorinscricao;
	
	public Materia(int codigo, String nomeMateria, int creditos, double valorinscricao) {
		this.codigo = codigo;
		this.nomeMateria = nomeMateria;
		this.creditos = creditos;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNomeMateria() {
		return nomeMateria;
	}
	public void setNomeMateria(String nomeMateria) {
		this.nomeMateria = nomeMateria;
	}
	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	public double getValorinscricao() {
		return valorinscricao;
	}
	public void setValorinscricao(double valorinscricao) {
		this.valorinscricao = valorinscricao;
	}
	
	

}
