package model;

public class Promocao {
	private int id;
	private String nomePromocao;
	private String tipoPromocao;
	private double desconto;
	private int fk_pacotesViagens_id;
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomePromocao() {
		return nomePromocao;
	}
	public void setNomePromocao(String nomePromocao) {
		this.nomePromocao = nomePromocao;
	}
	public String getTipoPromocao() {
		return tipoPromocao;
	}
	public void setTipoPromocao(String tipoPromocao) {
		this.tipoPromocao = tipoPromocao;
	}
	public double getDesconto() {
		return desconto;
	}
	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	public int getFk_pacotesViagens_id() {
		return fk_pacotesViagens_id;
	}
	public void setFk_pacotesViagens_id(int fk_pacotesViagens_id) {
		this.fk_pacotesViagens_id = fk_pacotesViagens_id;
	}
}
