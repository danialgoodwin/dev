/** Model a fraction and get the numerator and denominator or get the decimal.
 * 
 *  If the denominator is set to 0, then the returned decimal value will be 0.
 *
 *  Ex: In "3/4", 3 is the numerator, and 4 is the denominator.
 *
 *  Currently, only tested for positive numerator, denominator, and decimal.
 *  For more robustness and speed, possibly use the Apache Commons Math library's
 *  own Fraction object or just use the GCM method.
 *  */
public class Fraction {
	
	private int numerator;
	private int denominator;
	private double decimalValue;
	
	private Fraction(final double input) {
		double dec = input;
        String s = String.valueOf(dec);
        int digitsDec = s.length() - 1 - s.indexOf('.');

        // Convert to easy fractional form.
        int denom = 1;
        for (int i = 0; i < digitsDec; i++) {
        	dec *= 10;
            denom *= 10;
        }
        int num = (int) Math.round(dec);

        numerator = num;
        denominator = denom;
        decimalValue = input;

        reduce();
	}
	
	private Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.decimalValue = calculateDecimalValue(numerator, denominator);
	}
	
	public static Fraction createFromDecimal(double value) {
		return new Fraction(value);
	}
	
	public static Fraction createFromFraction(int numerator, int denominator) {
		return new Fraction(numerator, denominator);
	}
	
	public void setNumerator(int numerator) {
        this.numerator = numerator;
        this.decimalValue = calculateDecimalValue(numerator, denominator);
	}
	
	public void setDenominator(int denominator) {
        this.denominator = denominator;
        this.decimalValue = calculateDecimalValue(numerator, denominator);
	}
	
	public int getNumerator() {
		return numerator;
	}
	
	public int getDenominator() {
		return denominator;
	}
	
	public double getDecimalValue() {
		return decimalValue;
	}

    
    
	private static double calculateDecimalValue(int numerator, int denominator) {
		if (denominator == 0) { return 0.0; }
		return (double) numerator / denominator;
	}

	// TODO: Make this faster for the larger/smaller numbers.
	// Possibly use the Apache Commons Math library.
    private void reduce() {
        // Simple optimization
        if (numerator == 1 || denominator == 1) { return; }
        
        int n = numerator;
        int d = denominator;
        
//        int largest;
        int smallest; // Using "smallest" because it should be an optimization, rather than using "largest".

        // Find the larger of the numerator and denominator
        if (numerator < 0) {
            n = -numerator;
        }
        if (n > d) {
//            largest = n;
            smallest = d;
        } else {
//            largest = d;
            smallest = n;
        }

        // Find the largest number that divides the numerator and
        // denominator evenly
        int gcd = 0;
        for (int i = smallest; i >= 2; i--) {
            if (numerator % i == 0 && denominator % i == 0) {
                gcd = i;
                break;
            }
        }

        // Divide the largest common denominator out of numerator, denominator
        if (gcd != 0) {
        	numerator /= gcd;
            denominator /= gcd;
        }
    }

}
