package controller;
import java.util.Vector;

import view.CalculatorGui;
import model.Calculator;


public class CalculatorController implements CalculatorModelEventListener, CalculatorViewEventsListener{
    private Calculator calculatorModel;
    private AbstractCalculatorView calculatorView;

    public CalculatorController(Calculator model, AbstractCalculatorView view) {
	calculatorModel = model;
	calculatorView = view;	
	
	calculatorModel.registerListener(this);
	calculatorView.registerListener(this);
	
    }

    public Calculator getcalculatorModel() {
	return calculatorModel;
    }
    
    public void setcalculatorModel(Calculator calculatorModel) {
	this.calculatorModel = calculatorModel;
    }

    public AbstractCalculatorView getcalculatorView() {
	return calculatorView;
    }

    public Vector<CalculatorModelEventListener> getWarListeners() {
	return calculatorModel.getListeners();
    }

    public void setcalculatorView(AbstractCalculatorView calculatorView) {
	this.calculatorView = calculatorView;
    }

	@Override
	public void fireAdditionButtonEvent(String numerator1, String denumerator1,
			String numerator2, String denumerator2) {
		calculatorModel.calculateAddition(numerator1,denumerator1,numerator2,denumerator2);
		
	}

	@Override
	public void fireDenumeratorIsZeroEvenet() {
		calculatorView.denumeratorIsZeroEvenet();
		
	}

	@Override
	public void fireDivideNumerator2isZero() {
		calculatorView.divideNumerator2isZero();
		
	}

	@Override
	public void fireSubstractionButtonEvent(String numerator1,
			String denumerator1, String numerator2, String denumerator2) {
		calculatorModel.calculateSubstraction(numerator1,denumerator1,numerator2,denumerator2);
		
	}

	@Override
	public void addAdditionResultToView(String c1, String c2, String result) {
		calculatorView.showAdditionResult(c1,c2,result);
		
	}

	@Override
	public void addSubstructionResultToView(String c1, String c2, String result) {
		calculatorView.showSubstructionResult(c1,c2,result);
		
	}

	@Override
	public void fireMultiplicationButtonEvent(String numerator1,
			String denumerator1, String numerator2, String denumerator2) {
		calculatorModel.calculateMultiplication(numerator1,denumerator1,numerator2,denumerator2);
		
	}

	@Override
	public void addMultiplicationResultToView(String c1, String c2,
			String result) {
		calculatorView.showMultiplicationResult(c1,c2,result);
		
	}

	@Override
	public void fireDivisionButtonEvent(String numerator1, String denumerator1,
			String numerator2, String denumerator2) {
		calculatorModel.calculateDivision(numerator1,denumerator1,numerator2,denumerator2);
		
	}

	@Override
	public void addDivisionResultToView(String c1, String c2, String result) {
		calculatorView.showDivisionResult(c1,c2,result);
		
	}

	@Override
	public void fireCompareButtonEvent(String numerator1, String denumerator1,
			String numerator2, String denumerator2) {		
		calculatorModel.compareNumbers(numerator1,denumerator1,numerator2,denumerator2);

	}

	@Override
	public void addCompareResultToView(String c1, String c2,
			String sign) {
		calculatorView.showCompareResult(c1,c2,sign);
		
	}




}
