package ao.co.always.argentum.testes;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import ao.co.always.argentum.modelo.Candlestick;
import ao.co.always.argentum.modelo.CandlestickFactory;
import ao.co.always.argentum.modelo.Negociacao;

public class TestaCandlestickFactory {

	public static void main(String[] args) {
		
		Calendar hoje = Calendar.getInstance();
		
		Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
		Negociacao negociacao2 = new Negociacao(50.5, 100, hoje);
		Negociacao negociacao3 = new Negociacao(89.5, 100, hoje);
		Negociacao negociacao4 = new Negociacao(76.5, 100, hoje);

		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2,
											negociacao3, negociacao4);
		
		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);
		
		System.out.println(candle.getAbertura());
		System.out.println(candle.getFechamento());
		System.out.println(candle.getMaximo());
		System.out.println(candle.getMaximo());
		System.out.println(candle.getVolume());
	}

}
