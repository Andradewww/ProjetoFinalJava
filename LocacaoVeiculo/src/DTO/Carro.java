package DTO;

public class Carro { //marca, modelo, placa
	
	private int id;
	private String placa;
	private String marca;
	private String modelo;
	
	public Carro(int id, String placa, String marca, String modelo) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
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
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	/*  EXEMPLO PROFESSOR
	   @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Carro [id=");
		builder.append(id);
		builder.append(", placa=");
		builder.append(placa);
		builder.append("]");
		return builder.toString();
	}*/
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Carro [id=");
		builder.append(id);
		builder.append(", placa=");
		builder.append(placa);
		builder.append(", marca=");
		builder.append(marca);
		builder.append(", modelo=");
		builder.append(modelo);
		builder.append("]");
		return builder.toString();
	}
	
	
}