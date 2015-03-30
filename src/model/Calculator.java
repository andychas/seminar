package model;


import java.util.Vector;

import controller.CalculatorController;
import controller.CalculatorModelEventListener;

public class Calculator {
	 enum Operation {
		    ADDITION, SUBTRACTION , MULTIPLICATION, DIVISION, COMPARE
		}

	private Vector<CalculatorModelEventListener> allListeners;
	long numerator1, denumerator1, numerator2, denumerator2;
	RationalNumbers c1, c2;
	long result;
	

	
	
	public Calculator(){
		allListeners = new Vector<CalculatorModelEventListener>();
	}

	
	
	public void registerListener(CalculatorController calculatorController) {
		allListeners.add(calculatorController);		
	}



	public Vector<CalculatorModelEventListener> getListeners() {
		return allListeners;
	}




	public void calculate(Operation operation, String n1,
			String d1, String n2, String d2) {	
		
		try {
			numerator1 = new Integer(n1).intValue();
			denumerator1 = new Integer(d1).intValue();
			numerator2 = new Integer(n2).intValue();
			denumerator2 = new Integer(d2).intValue();
			
		} catch (Exception e) {
			// TODO: handle (NOT INTEGER) exception
		}
		
		
		if (denumerator1 == 0 || denumerator2 == 0) {
			
			for (CalculatorModelEventListener listener : allListeners) {
				listener.fireDenumeratorIsZeroEvenet();
			}
			return;
		}							
		if (operation == Operation.DIVISION && numerator2 == 0) {
			for (CalculatorModelEventListener listener : allListeners) {
				listener.fireDivideNumerator2isZero();
			}
			return;
		}
		
		c1 = new RationalNumbers(numerator1, denumerator1);
		c2 = new RationalNumbers(numerator2, denumerator2);
		
		switch (operation) {
		case ADDITION:
			for (CalculatorModelEventListener listener : allListeners) {
				listener.addAdditionResultToView(
						c1.toString(),c2.toString(), (c1.add(c2)).toString());						  						
			}
			break;
			
		case SUBTRACTION:
			for (CalculatorModelEventListener listener : allListeners) {
				listener.addSubstructionResultToView(
						c1.toString(),c2.toString(), (c1.subtract(c2)).toString());
			}
			
			break;
			
		case MULTIPLICATION:
			for (CalculatorModelEventListener listener : allListeners) {
				listener.addMultiplicationResultToView(
						c1.toString(),c2.toString(), (c1.multiply(c2)).toString());
			}
			
			break;
		case DIVISION:
			for (CalculatorModelEventListener listener : allListeners) {
				listener.addDivisionResultToView(
						c1.toString(),c2.toString(), (c1.divide(c2)).toString());
			}
			
			break;
		case COMPARE:
			String sign;
			if(c1.compareTo(c2) > 0)
				sign = ">";
			else if(c1.compareTo(c2) < 0)
				sign = "<";
			else
				sign = "=";
			
						
			for (CalculatorModelEventListener listener : allListeners) {
				listener.addCompareResultToView(
						c1.toString(),c2.toString(),sign);
			}
			
			break;

		default:
			break;
		}
		
	}



	public void calculateSubstraction(String numerator1, String denumerator1,
			String numerator2, String denumerator2) {
		calculate(Operation.SUBTRACTION,numerator1,denumerator1,numerator2,denumerator2 );
		
	}
	
	public void calculateAddition(String numerator1, String denumerator1,
			String numerator2, String denumerator2) {
		
		calculate(Operation.ADDITION,numerator1,denumerator1,numerator2,denumerator2 );			
		
	}



	public void calculateMultiplication(String numerator1,
			String denumerator1, String numerator2, String denumerator2) {
		calculate(Operation.MULTIPLICATION,numerator1,denumerator1,numerator2,denumerator2 );
		
	}



	public void calculateDivision(String numerator1,
			String denumerator1, String numerator2, String denumerator2) {
		calculate(Operation.DIVISION,numerator1,denumerator1,numerator2,denumerator2 );
		
	}



	public void compareNumbers(String numerator1,
			String denumerator1, String numerator2, String denumerator2) {
		calculate(Operation.COMPARE,numerator1,denumerator1,numerator2,denumerator2 );
		
	}

}
