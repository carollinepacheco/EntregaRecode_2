package model;

public class Promocao {
	private int id;
	private String nomePromocao;
	private String tipoPromocao;
	private double desconto;
	private int fk_pacoteViagens_id;
		
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
	public int getFk_pacoteViagens_id() {
		return fk_pacoteViagens_id;
	}
	public void setFk_pacoteViagens_id(int fk_pacoteViagens_id) {
		this.fk_pacoteViagens_id = fk_pacoteViagens_id;
	}
}
