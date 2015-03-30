package model;


public class RationalNumbers implements Comparable<Object> {
	private long numerator = 0;
	private long denominator = 1;
	
	public RationalNumbers(long numerator, long denominator) {
		long gcd = gcd(numerator, denominator);
		this.numerator = ((denominator > 0) ? 1 : -1) * numerator / gcd;
		this.denominator = Math.abs(denominator) / gcd;
	}

	private long gcd(long n, long d) {
		long t1 = Math.abs(n);
		long t2 = Math.abs(d);
		long remainder = t1 % t2;
		while (remainder != 0) {
			t1 = t2;
			t2 = remainder;
			remainder = t1 % t2;
		}
		return t2;
	}

	public long getNumerator() {
		return numerator;
	}

	public long getDenominator() {
		return denominator;
	}

	public RationalNumbers add(RationalNumbers secondRational) {
		long n = numerator * secondRational.getDenominator() + denominator
				* secondRational.getNumerator();
		long d = denominator * secondRational.getDenominator();
		return new RationalNumbers(n, d);
	}

	public RationalNumbers subtract(RationalNumbers secondRational) {
		long n = numerator * secondRational.getDenominator() - denominator
				* secondRational.getNumerator();
		long d = denominator * secondRational.getDenominator();
		return new RationalNumbers(n, d);
	}

	public RationalNumbers multiply(RationalNumbers secondRational) {
		long n = numerator * secondRational.getNumerator();
		long d = denominator * secondRational.getDenominator();
		return new RationalNumbers(n, d);
	}

	public RationalNumbers divide(RationalNumbers secondRational) {
		long n = numerator * secondRational.getDenominator();
		long d = denominator * secondRational.numerator;
		return new RationalNumbers(n, d);
	}

	@Override
	public boolean equals(Object parm1) {
		if ((this.subtract((RationalNumbers) (parm1))).getNumerator() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public int compareTo(Object o) {
		if ((this.subtract((RationalNumbers) o)).getNumerator() > 0) {
			return 1;
		} else if ((this.subtract((RationalNumbers) o)).getNumerator() < 0) {
			return -1;
		} else {
			return 0;
		}
	}
	public String toString() {
		if (denominator == 1)
			return numerator + "";
		else
			return numerator + "/" + denominator;
	}

}
