package view;

import java.util.LinkedList;
import java.util.List;

import model.Calculator;
import controller.AbstractCalculatorView;
import controller.CalculatorController;
import controller.CalculatorViewEventsListener;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class CalculatorGui extends Application implements AbstractCalculatorView {
	
	public static void main(String[] args) {				
		launch(args);	
	}
	
	private static final String TITLE = "Rational Numbers Calculator";
	private Label lblNumerator1, lblDeNumerator1, 
				  lblNumerator2, lblDeNumerator2, 
				  lblResult;
	private List<CalculatorViewEventsListener> allListeners;
	
	private TextField tfNumerator1, tfDeNumerator1, 
					  tfNumerator2, tfDeNumerator2, 
					  tfResult;
	private Button btAdd, btSub, btMul, btDiv, btCompare, btUndo, btRedo;
	

	public void start(Stage primaryStage) throws Exception {	
		
		
		allListeners= new LinkedList<CalculatorViewEventsListener>();
		Font largeFont = Font.font("Droid Sans", FontWeight.BOLD, 15);
		TilePane dataPane = new TilePane();
		dataPane.setPrefColumns(8);
		dataPane.setPadding(new Insets(10, 10, 10, 0));
		dataPane.setVgap(4);
		dataPane.setHgap(5);
		dataPane.getChildren().add(lblNumerator1 = new Label("Numerator 1: "));
		dataPane.getChildren().add(tfNumerator1 = new TextField());
		tfNumerator1.setPrefColumnCount(7);
		dataPane.getChildren().add(
				lblDeNumerator1 = new Label("Denumerator 1: "));
		dataPane.getChildren().add(tfDeNumerator1 = new TextField());
		tfDeNumerator1.setPrefColumnCount(7);
		dataPane.getChildren().add(lblNumerator2 = new Label("Numerator 2: "));
		dataPane.getChildren().add(tfNumerator2 = new TextField());
		tfNumerator2.setPrefColumnCount(7);
		dataPane.getChildren().add(
				lblDeNumerator2 = new Label("Denumerator 2: "));
		dataPane.getChildren().add(tfDeNumerator2 = new TextField());
		tfDeNumerator2.setPrefColumnCount(7);
		FlowPane resultPane = new FlowPane();
		resultPane.getChildren().add(lblResult = new Label("Result: "));
		resultPane.getChildren().add(tfResult = new TextField());
		resultPane.setAlignment(Pos.CENTER);
		resultPane.setHgap(10);
		resultPane.setPadding(new Insets(0, 10, 10, 0));
		tfResult.setPrefColumnCount(50);
		tfResult.setEditable(false);
		tfResult.setFont(largeFont);
		FlowPane buttonsPane = new FlowPane();
		buttonsPane.setAlignment(Pos.CENTER);
		buttonsPane.setPadding(new Insets(10, 10, 10, 10));
		buttonsPane.setHgap(20);
		buttonsPane.getChildren().add(btAdd = new Button("Add"));
		buttonsPane.getChildren().add(btSub = new Button("Subtract"));
		buttonsPane.getChildren().add(btMul = new Button("Multiply"));
		buttonsPane.getChildren().add(btDiv = new Button("Divide"));
		buttonsPane.getChildren().add(btCompare = new Button("Compare"));
		buttonsPane.getChildren().add(btUndo = new Button("Undo"));
		buttonsPane.getChildren().add(btRedo = new Button("Redo"));
		GridPane mainPane = new GridPane();
		mainPane.setHgap(10);
		mainPane.setVgap(10);
		mainPane.add(dataPane, 0, 0);
		mainPane.add(buttonsPane, 0, 1);
		mainPane.add(resultPane, 0, 2);
		mainPane.setAlignment(Pos.CENTER);
		TitledPane titledPane = new TitledPane(TITLE, mainPane);
		Scene scene = new Scene(titledPane);
		primaryStage.setScene(scene);
		primaryStage.show();
														
		setMnemonics(btAdd, KeyCode.A);
		setMnemonics(btSub, KeyCode.S);
		setMnemonics(btDiv, KeyCode.D);
		setMnemonics(btMul, KeyCode.M);
		setMnemonics(btCompare, KeyCode.C);
		setMnemonics(btUndo, KeyCode.Z);
		setMnemonics(btRedo, KeyCode.Y);
	
		// TODO - find a way to pass an instance of this javafx application from an outer class
				Calculator calculatorModel = new Calculator();
				new CalculatorController(calculatorModel, this);

	/////////////// Button Action Listeners  ////////////
	
	//addition	
	btAdd.setOnAction(new EventHandler<ActionEvent>() {
		public void handle(ActionEvent event) {
			createAdditionButtonEvent();			
		}
	});
	
	//Subtraction 
	btSub.setOnAction(new EventHandler<ActionEvent>() {
		
		@Override
		public void handle(ActionEvent event) {
			createSubstractionButtonEvent();
			
		}
	});
	
	//Multiplication
	btMul.setOnAction(new EventHandler<ActionEvent>() {
		
		@Override
		public void handle(ActionEvent event) {
			createMultiplicationButtonEvent();
			
		}
	});
	
	//Division
	btDiv.setOnAction(new EventHandler<ActionEvent>() {
		
		@Override
		public void handle(ActionEvent event) {
			createDivisionButtonEvent();
			
		}
	});	
	
	//Compare
	btCompare.setOnAction(new EventHandler<ActionEvent>() {
		
		@Override
		public void handle(ActionEvent event) {
			createCompareButtonEvent();
			
		}
	});	
	
	//Undo
	btUndo.setOnAction(new EventHandler<ActionEvent>() {
		
		@Override
		public void handle(ActionEvent event) {
			createUndoButtonEvent();
			
		}
	});	
	
	//Re-do
	btRedo.setOnAction(new EventHandler<ActionEvent>() {
		
		@Override
		public void handle(ActionEvent event) {
			createRedoButtonEvent();
			
		}
	});
	
	} // end of start() method
	
	private void setMnemonics(Button button, KeyCode kc) {
		Scene scene = button.getScene();
		if (scene == null) {
			throw new IllegalArgumentException(
					"setSaveAccelerator must be called when a"
							+ " button is attached to a scene");
		}
		button.setMnemonicParsing(true);
		scene.getAccelerators().put(
				new KeyCodeCombination(kc, KeyCombination.CONTROL_DOWN),
				new Runnable() {
					@Override
					public void run() {
						button.fire();
					}
				});
	}
	

	public void createRedoButtonEvent() {
		for (CalculatorViewEventsListener listener : allListeners) {
			listener.fireRedoButtonEvent();
		}		
	}

	public void createUndoButtonEvent() {
		for (CalculatorViewEventsListener listener : allListeners) {
			listener.fireUndoButtonEvent();
		}		
	}

	public void createCompareButtonEvent() {
		for (CalculatorViewEventsListener listener : allListeners) {
			listener.fireCompareButtonEvent(
					tfNumerator1.getText().trim(),tfDeNumerator1.getText().trim(),
					tfNumerator2.getText().trim(),tfDeNumerator2.getText().trim()  
					);
		}
		
	}

	public void createDivisionButtonEvent() {
		for (CalculatorViewEventsListener listener : allListeners) {
			listener.fireDivisionButtonEvent(
					tfNumerator1.getText().trim(),tfDeNumerator1.getText().trim(),
					tfNumerator2.getText().trim(),tfDeNumerator2.getText().trim()  
					);
		}
		
	}

	public void createMultiplicationButtonEvent() {
		for (CalculatorViewEventsListener listener : allListeners) {
			listener.fireMultiplicationButtonEvent(
					tfNumerator1.getText().trim(),tfDeNumerator1.getText().trim(),
					tfNumerator2.getText().trim(),tfDeNumerator2.getText().trim()  
					);
		}
		
	}

	public void createSubstractionButtonEvent() {
		for (CalculatorViewEventsListener listener : allListeners) {
			listener.fireSubstractionButtonEvent(
					tfNumerator1.getText().trim(),tfDeNumerator1.getText().trim(),
					tfNumerator2.getText().trim(),tfDeNumerator2.getText().trim()  
					);
		}
		
	}

	public void createAdditionButtonEvent() {
		for (CalculatorViewEventsListener listener : allListeners) {
			listener.fireAdditionButtonEvent(
					tfNumerator1.getText().trim(),tfDeNumerator1.getText().trim(),
					tfNumerator2.getText().trim(),tfDeNumerator2.getText().trim()  
					);
		}
		
	}

	@Override
	public void denumeratorIsZeroEvenet() {
		tfResult.setText("Denumerators must be Non Zero.");
		
	}

	@Override
	public void divideNumerator2isZero() {
		tfResult.setText("For devide operation Numerator 2 must be Non Zero.");
		
	}

	@Override
	public void registerListener(CalculatorController listener) {
		allListeners.add(listener);
		
	}

	@Override
	public void showAdditionResult(String c1, String c2, String result) {
		tfResult.setText(c1 + " + " + c2 + " = " + result);
		
	}

	@Override
	public void showSubstructionResult(String c1, String c2, String result) {
		tfResult.setText(c1 + " - " + c2 + " = " + result);	
	}


	@Override
	public void showMultiplicationResult(String c1, String c2, String result) {
		tfResult.setText(c1 + " * " + c2 + " = " + result);
		
	}

	@Override
	public void showDivisionResult(String c1, String c2, String result) {
		tfResult.setText(c1 + " / " + c2 + " = " + result);
		
	}

	@Override
	public void showCompareResult(String c1, String c2,
			String sign) {
		if(sign == "<")
			tfResult.setText(c1 + " is less than " + c2);
		else if (sign == ">")
			tfResult.setText(c1 + " is greater than " + c2);
		else
			tfResult.setText(c1 + " is equal to " + c2);
					
	}

	@Override
	public void noPreviousOperations() {
		tfResult.setText("No previous actions.");		
	}

	@Override
	public void noFurtherOperations() {
		tfResult.setText("No further actions.");
		
	}

	@Override
	public void wrongInput() {
		tfResult.setText("Wrong Input, Be sure to enter Integers");
		
	}
	
}
