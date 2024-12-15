package DTO;

import java.util.Date;

public class Locacao {
    
    private int id;
    private Carro carro;
    private Agente agenteLocacao;
    private Cliente cliente;
    private Date dataInicio;
    private Date dataFim;

    public Locacao(int id, Carro carro, Agente agenteLocacao, Cliente cliente, Date dataInicio, Date dataFim) {
        this.id = id;
        this.carro = carro;
        this.agenteLocacao = agenteLocacao;
        this.cliente = cliente;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Carro getVeiculo() {
        return carro;
    }
    public void setVeiculo(Carro carro) {
        this.carro = carro;
    }
    public Agente getAgenteLocacao() {
        return agenteLocacao;
    }
    public void setAgenteLocacao(Agente agenteLocacao) {
        this.agenteLocacao = agenteLocacao;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
        builder.append(", veiculo=");
        builder.append(carro != null ? carro.getPlaca() : "N/A");
        builder.append(", agenteLocacao=");
        builder.append(agenteLocacao != null ? agenteLocacao.getNome() : "N/A");
        builder.append(", cliente=");
        builder.append(cliente != null ? cliente.getNome() : "N/A");
        builder.append(", dataInicio=");
        builder.append(dataInicio);
        builder.append(", dataFim=");
        builder.append(dataFim);
        builder.append("]");
        return builder.toString();
    }
}