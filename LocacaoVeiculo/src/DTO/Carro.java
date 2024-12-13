package DTO;

public class Carro {
	
	private int id;
	private String placa;
	
	public Carro() {

	}
	public Carro(int id) {
		setId(id);
	}
	public Carro(String placa) {
		setPlaca(placa);
	}
	public Carro(int id, String placa) {
		setId(id);
		setPlaca(placa);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Carro [id=");
		builder.append(id);
		builder.append(", placa=");
		builder.append(placa);
		builder.append("]");
		return builder.toString();
	}
}