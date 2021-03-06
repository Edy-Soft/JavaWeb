package ao.co.always.argentum.modelo;
import java.util.Calendar;

public final class Negociacao {
	
	public Negociacao(double preco, int quantidade, Calendar data) {
		
		if (data == null) {
			throw new IllegalArgumentException("data nao pode ser nula");
			}
		
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
	}
	private final double preco;
	private final int quantidade;
	private final Calendar data;
	
	public double getPreco() {
		return preco;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public Calendar getData() {
		return (Calendar) this.data.clone();
	}
	
	public double getVolume(){
		return preco * quantidade;
	}
	
}
