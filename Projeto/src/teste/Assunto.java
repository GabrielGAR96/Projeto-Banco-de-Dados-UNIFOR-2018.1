package teste;

public class Assunto {
	private int CodigoAssunto;
	private String nomeAssunto;
	private int CodigoMateria;
	
	public Assunto(int codigoAssunto, String nomeAssunto, int codigo) {
		CodigoAssunto = codigoAssunto;
		this.nomeAssunto = nomeAssunto;
		CodigoMateria = codigo;
	}
	
	public int getCodigoAssunto() {
		return CodigoAssunto;
	}
	public void setCodigoAssunto(int codigoAssunto) {
		CodigoAssunto = codigoAssunto;
	}
	public String getNomeAssunto() {
		return nomeAssunto;
	}
	public void setNomeAssunto(String nomeAssunto) {
		this.nomeAssunto = nomeAssunto;
	}
	public int getCodigo() {
		return CodigoMateria;
	}
	public void setCodigo(int codigo) {
		CodigoMateria = codigo;
	}
	
}
