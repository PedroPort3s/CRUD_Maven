package helper;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Verifica {

	public static long ConverterNumeroLong(String numeros) {
		try {
			return Long.parseLong(numeros);
			
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public static int ConverterNumeroInt(String numeros) {
		try {
			return Integer.parseInt(numeros);
			
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public static float ConverterNumeroFloat(String numeros) {
		try {
			return Float.parseFloat(numeros);
			
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public static double ConverterNumeroDouble(String numeros) {
		try {
			return Double.parseDouble(numeros);
			
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public static boolean ehNumeroInt(double numero) {

		if ((numero == Math.floor(numero)) && !Double.isInfinite(numero)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static double Arredondar(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = BigDecimal.valueOf(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	

}
