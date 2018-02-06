package lab7;

public class MyFraction implements MyMath<MyFraction> {

	private int numerator;
	private int denominator;
	private char sign;

	public MyFraction(int numerator, int denominator, char sign) {
		
		this.numerator = numerator;
		this.denominator = denominator;
		this.sign = sign;
		
		this.simplify();
	}

	@Override
	public MyFraction add(MyFraction o) {
		
		int newDenom = 0;
		
		int newNumer = 0;
		
		char newSign = ' ';
		
		if (this.denominator == o.denominator) {  
			
			newDenom = this.denominator;
			
			if (this.sign == '+' && o.sign == '+') {
				
				newNumer = this.numerator + o.numerator;
				
			}	else if (this.sign == '-' && o.sign == '-') {
				
				newNumer = -this.numerator - o.numerator;
			}
				else if (this.sign == '-' && o.sign == '+') {
				
				newNumer = -this.numerator + o.numerator;
				
			}	else if (this.sign == '+' && o.sign == '-') {
				
				newNumer = this.numerator - o.numerator;
			}
		}	
		
		if (this.denominator != o.denominator) {  
			
			newDenom = this.denominator * o.denominator;
			
			if (this.sign == '+' && o.sign == '+') {
				
				newNumer = (this.numerator * o.denominator) + (o.numerator * this.denominator);
				
			}	else if (this.sign == '-' && o.sign == '-') {
				
				newNumer = -(this.numerator * o.denominator) - (o.numerator * this.denominator);
				
			}	else if (this.sign == '-' && o.sign == '+') {
				
				newNumer = -(this.numerator * o.denominator) + (o.numerator * this.denominator);
				
			}	else if (this.sign == '+' && o.sign == '-') {
				
				newNumer = (this.numerator * o.denominator) - (o.numerator * this.denominator);
			}
		}	
		
		if (newNumer < 0) {
			
			newSign = '-';
			newNumer = Math.abs(newNumer);
			
		} else {
			
			newSign = '+';
		}
		
		return new MyFraction(newNumer, newDenom, newSign);

	}

	@Override
	public MyFraction subtract(MyFraction o) {
		
		int newDenom = 0;
		
		int newNumer = 0;
		
		char newSign = ' ';
		
		if (this.denominator == o.denominator) {  
			
			newDenom = this.denominator;
			
			if (this.sign == '+' && o.sign == '+') {
				
				newNumer = this.numerator - o.numerator;
				
			}	else if (this.sign == '-' && o.sign == '-') {
				
				newNumer = -this.numerator + o.numerator;
			}
				else if (this.sign == '-' && o.sign == '+') {
				
				newNumer = -this.numerator - o.numerator;
				
			}	else if (this.sign == '+' && o.sign == '-') {
				
				newNumer = this.numerator + o.numerator;
			}
		}	
		
		if (this.denominator != o.denominator) {  
			
			newDenom = this.denominator * o.denominator;
			
			if (this.sign == '+' && o.sign == '+') {
				
				newNumer = (this.numerator * o.denominator) - (o.numerator * this.denominator);
				
			}	else if (this.sign == '-' && o.sign == '-') {
				
				newNumer = -(this.numerator * o.denominator) + (o.numerator * this.denominator);
				
			}	else if (this.sign == '-' && o.sign == '+') {
				
				newNumer = -(this.numerator * o.denominator) - (o.numerator * this.denominator);
				
			}	else if (this.sign == '+' && o.sign == '-') {
				
				newNumer = (this.numerator * o.denominator) + (o.numerator * this.denominator);
			}
		}	
		
		if (newNumer < 0) {
			
			newSign = '-';
			newNumer = Math.abs(newNumer);
			
		} else {
			
			newSign = '+';
		}
		
		return new MyFraction(newNumer, newDenom, newSign);

	}

	@Override
	public MyFraction divide(MyFraction o) {

		int newNumer = this.numerator * o.denominator;
		
		int newDenom = this.denominator * o.numerator;
		
		char newSign = ' ';
		
		if ((this.sign == '+' && o.sign == '+') || (this.sign == '-' && o.sign == '-')) {
			
			newSign = '+';
		}	else {
			newSign = '-';
		}
		
		return new MyFraction(newNumer, newDenom, newSign);
	}

	@Override
	public MyFraction multiply(MyFraction o) {

		int newDenom = this.denominator * o.denominator;
		
		int newNumer = this.numerator * o.numerator;
		
		char newSign = ' ';
		
		if ((this.sign == '+' && o.sign == '+') || (this.sign == '-' && o.sign == '-')) {
			
			newSign = '+';
		} else {
			
			newSign = '-';
		}
		
		return new MyFraction(newNumer, newDenom, newSign);
	}
	
	public void simplify() {
		
		int max = Math.max(numerator, denominator);
				
		while (max > 2) {
		
		if (this.numerator % max == 0 && this.denominator % max == 0) {
		
			this.numerator /= max;
			this.denominator /= max;
			
			max = Math.max(numerator, denominator);
			
			} else {
				
				max--;
			}
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj == this) {
			
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			
			return false;
		}
		
		MyFraction test = (MyFraction)obj;
		
		if(test.denominator == this.denominator && test.numerator == this.numerator && test.sign == this.sign) {
			
			return true;
		}
		
		return false;
	}
	
	public String toString() {
		
		return "" + sign + numerator + "/" + denominator;
	}
}
