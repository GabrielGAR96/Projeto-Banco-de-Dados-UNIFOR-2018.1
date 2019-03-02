package teste;

public class Respostas {
	private int idrespostas;
	private String texto;
	private int codigoperguntas;	
	
	public Respostas(int idrespostas, String texto, int codigoperguntas) {
		this.idrespostas = idrespostas;
		this.texto = texto;
		this.codigoperguntas = codigoperguntas;
	}
	
	public int getIdrespostas() {
		return idrespostas;
	}
	public void setIdrespostas(int idrespostas) {
		this.idrespostas = idrespostas;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public int getCodigoperguntas() {
		return codigoperguntas;
	}
	public void setCodigoperguntas(int codigoperguntas) {
		this.codigoperguntas = codigoperguntas;
	}

}
