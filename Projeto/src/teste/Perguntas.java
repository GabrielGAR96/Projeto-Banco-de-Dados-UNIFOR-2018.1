package teste;

public class Perguntas {
	
	private int idperguntas;
	private String enunciado;	
	private boolean objetiva;
	private int idassunto;
	private int idsimulado;
	
	
	public Perguntas(int idperguntas, String enunciado, boolean objetiva, int idassunto, int idsimulado) {
		this.idperguntas = idperguntas;
		this.enunciado = enunciado;
		this.idassunto = idassunto;
		this.objetiva = objetiva;
	}
	
	public int getIdperguntas() {
		return idperguntas;
	}
	public void setIdperguntas(int idperguntas) {
		this.idperguntas = idperguntas;
	}
	public String getEnunciado() {
		return enunciado;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	public int getIdassunto() {
		return idassunto;
	}
	public void setIdassunto(int idassunto) {
		this.idassunto = idassunto;
	}
	public boolean isObjetiva() {
		return objetiva;
	}
	public void setObjetiva(boolean objetiva) {
		this.objetiva = objetiva;
	}

	public int getIdsimulado() {
		return idsimulado;
	}

	public void setIdsimulado(int idsimulado) {
		this.idsimulado = idsimulado;
	}
}
