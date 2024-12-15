package DTO;
import java.util.Date;

public class Locacao {
	
	private int id;
	private String placaVeiculo;
	private String AgenteLocacao;
	private Date dataInicio;
	private Date dataFim;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlacaVeiculo() {
		return placaVeiculo;
	}
	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}
	public String getAgenteLocacao() {
		return AgenteLocacao;
	}
	public void setAgenteLocacao(String agenteLocacao) {
		AgenteLocacao = agenteLocacao;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Locacao [id=");
		builder.append(id);
		builder.append(", placaVeiculo=");
		builder.append(placaVeiculo);
		builder.append(", AgenteLocacao=");
		builder.append(AgenteLocacao);
		builder.append(", dataInicio=");
		builder.append(dataInicio);
		builder.append(", dataFim=");
		builder.append(dataFim);
		builder.append("]");
		return builder.toString();
	}
}
