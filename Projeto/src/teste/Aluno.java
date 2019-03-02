package teste;

import java.sql.Date;

public class Aluno {

	private int idaluno;
	private String nome;
	private String endereco;
	private Date datainscricao;
	private double inscricao;
	private String login_username;
	private boolean pagamento;
	
	public Aluno(int idaluno, String nome, String endereco, Date datainscricao, double inscricao, String login_username) {
		this.idaluno = idaluno;
		this.nome = nome;
		this.endereco = endereco;
		this.datainscricao = datainscricao;
		this.inscricao = inscricao;
		this.login_username = login_username;
	}
	
	public int getIdaluno() {
		return idaluno;
	}
	public void setIdaluno(int idaluno) {
		this.idaluno = idaluno;
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
	public Date getDatainscricao() {
		return datainscricao;
	}

	public void setDatainscricao(Date datainscricao) {
		this.datainscricao = datainscricao;
	}

	public double getInscricao() {
		return inscricao;
	}
	public void setInscricao(double inscricao) {
		this.inscricao = inscricao;
	}
	public String getLogin_username() {
		return login_username;
	}
	public void setLogin_username(String login_username) {
		this.login_username = login_username;
	}
	public boolean getPagamento() {
		return pagamento;
	}
	
	public void setPagamento(boolean pagamento) {
		this.pagamento = pagamento;
	}
	
}
