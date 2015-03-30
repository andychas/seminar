package controller;

public interface AbstractCalculatorView {

	void denumeratorIsZeroEvenet();

	void divideNumerator2isZero();

	void registerListener(CalculatorController listener);

	void showAdditionResult(String c1, String c2, String result);

	void showSubstructionResult(String c1, String c2, String result);

	void showMultiplicationResult(String c1, String c2, String result);

	void showDivisionResult(String c1, String c2, String result);

	void showCompareResult(String c1, String c2, String sign);
}
