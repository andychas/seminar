package controller;


import java.io.Serializable;

public interface CalculatorModelEventListener extends Serializable {

	void fireDenumeratorIsZeroEvenet();

	void fireDivideNumerator2isZero();

	void addAdditionResultToView(String c1, String c2, String result);

	void addSubstructionResultToView(String c1, String c2,
			String result);

	void addMultiplicationResultToView(String c1, String c2, String result);

	void addDivisionResultToView(String c1, String c2, String result);

	void addCompareResultToView(String c1, String c2, String result);


}
