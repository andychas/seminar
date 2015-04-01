package controller;

import java.io.Serializable;


public interface CalculatorViewEventsListener extends Serializable{

	void fireAdditionButtonEvent(String numerator1, String denumerator1,
							String numerator2, String denumerator2);

	void fireSubstractionButtonEvent(String numerator1, String denumerator1,
							String numerator2, String denumerator2);

	void fireMultiplicationButtonEvent(String numerator1, String denumerator1,
							String numerator2, String denumerator2);

	void fireDivisionButtonEvent(String numerator1, String denumerator1,
							String numerator2, String denumerator2);

	void fireCompareButtonEvent(String numerator1, String denumerator1,
							String numerator2, String denumerator2);

	void fireUndoButtonEvent();

	void fireRedoButtonEvent();
	

}
