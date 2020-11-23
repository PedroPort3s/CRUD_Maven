package helper;

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

}
