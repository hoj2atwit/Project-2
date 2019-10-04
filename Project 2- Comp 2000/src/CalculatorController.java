import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class CalculatorController extends Calculator implements Initializable {
	@FXML
	private static Button quitButton;
	@FXML
	private Button button1;
	@FXML
	private Button button2;
	@FXML
	private Button button3;
	@FXML
	private Button button4;
	@FXML
	private Button button5;
	@FXML
	private Button button6;
	@FXML
	private Button button7;
	@FXML
	private Button button8;
	@FXML
	private Button button9;
	@FXML
	private Button button0;
	@FXML
	private Button subtractButton;
	@FXML
	private Button plusButton;
	@FXML
	private Button multiplyButton;
	@FXML
	private Button divideButton;
	@FXML
	private Button clearButton;
	@FXML
	private Button deleteButton;
	@FXML
	private Button openPButton;
	@FXML
	private Button closedPButton;
	@FXML
	private Button equalsButton;
	@FXML
	private Text operationText;
	@FXML
	private Text errorText;
	@FXML
	private AnchorPane calculatorWindow;
	
	public void update() {
		operationText.setText(getInfix());
		errorText.setText(getErrorMessage());
	}
	
	public void divide() {
		if(!getInfix().equals("")) {
			input("/");
		}
		update();
	}
	
	public void multiply() {
		if(!getInfix().equals("")) {
			input("*");
		}
		update();
	}

	public void add() {
		if(!getInfix().equals("")) {
			input("+");
		}
		update();
	}
	
	public void subtract() {
		if(!getInfix().equals("")) {
			input("-");
		}
		update();
	}
	
	public void one() {
		input("1");
		update();
	}
	public void two() {
		input("2");
		update();
	}
	public void three() {
		input("3");
		update();
	}
	public void four() {
		input("4");
		update();
	}
	public void five() {
		input("5");
		update();
	}
	public void six() {
		input("6");
		update();
	}
	public void seven() {
		input("7");
		update();
	}
	public void eight() {
		input("8");
		update();
	}
	public void nine() {
		input("9");
		update();
	}
	public void zero() {
		if(!getInfix().substring(getInfix().length()-1).equals("/")) {
			input("0");
		}else {
			setErrorMessage("Cannot Divide by 0.");
		}
		update();
	}
	
	public void openParenthesis() {
		input("(");
		update();
	}
	
	public void closedParenthesis() {
		input(")");
		update();
	}
	
	public void clear() {
		setInfix("");
		setErrorMessage("");
		setHasAnswer(false);
		update();
	}
	
	public void delete() {
		if(!getInfix().equals("")) {
			setInfix(getInfix().substring(0, getInfix().length()-1));
		}
		update();
	}
	
	public void quit() {
		System.exit(0);
	}
	
	public void equal() {
		calculate();
		update();
	}

	/**
	 * Method that holds what each button does within the world
	 */
	public void keyPressedShift() {
		calculatorWindow.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent e) {
				if(e.getCode() == KeyCode.DIGIT8) { 
		    		  multiply();
		    	}
				if(e.getCode() == KeyCode.EQUALS) { 
		    		  add();
		    	}
				if(e.getCode() == KeyCode.DIGIT9) { 
		    		  openParenthesis();
		    	}
				if(e.getCode() == KeyCode.DIGIT0) { 
		    		  closedParenthesis();
		    	}
				if(e.getCode() == KeyCode.ENTER) { 
		    		  equal();
		    	}
				if(e.getCode() == KeyCode.ESCAPE || e.getCode() == KeyCode.Q) {
		    		 quit();
		    	}
				if(e.getCode() == KeyCode.C) { 
		    		  clear();
				}
				if(e.getCode() == KeyCode.BACK_SPACE) { 
		    		  delete();
		    	  }
				e.consume();
			}
			
		});
		calculatorWindow.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent e) {
				if(e.getCode() == KeyCode.SHIFT) {
					keyPressedNormal();
				}
				e.consume();
			}
			
		});
		
			
	}
	
	/**
	 * Method that holds what each button does within the world
	 */
	public void keyPressedNormal() {
		calculatorWindow.setOnKeyPressed(new EventHandler<KeyEvent>() {
		      @Override
		      public void handle(KeyEvent e) {
		    	  if(e.getCode() == KeyCode.NUMPAD1 || e.getCode() == KeyCode.DIGIT1) {
		    		  one();
		    	  }
		    	  if(e.getCode() == KeyCode.NUMPAD2 || e.getCode() == KeyCode.DIGIT2) {
		    		  two();
		    	  }
		    	  if(e.getCode() == KeyCode.NUMPAD3 || e.getCode() == KeyCode.DIGIT3) {
		    		  three();
		    	  }
		    	  if(e.getCode() == KeyCode.NUMPAD4 || e.getCode() == KeyCode.DIGIT4) { 
		    		  four();
		    	  }
		    	  if(e.getCode() == KeyCode.NUMPAD5 || e.getCode() == KeyCode.DIGIT5) { 
		    		  five();
		    	  }
		    	  if(e.getCode() == KeyCode.NUMPAD6 || e.getCode() == KeyCode.DIGIT6) { 
		    		  six();
		    	  }
		    	  if(e.getCode() == KeyCode.NUMPAD7 || e.getCode() == KeyCode.DIGIT7) { 
		    		  seven();
		    	  }
		    	  if(e.getCode() == KeyCode.NUMPAD8 || e.getCode() == KeyCode.DIGIT8) { 
		    		  eight();
		    	  }
		    	  if(e.getCode() == KeyCode.NUMPAD9 || e.getCode() == KeyCode.DIGIT9) { 
		    		  nine();
		    	  }
		    	  if(e.getCode() == KeyCode.NUMPAD0 || e.getCode() == KeyCode.DIGIT0) { 
		    		  zero();
		    	  }
		    	  if(e.getCode() == KeyCode.BACK_SPACE) { 
		    		  delete();
		    	  }
		    	  if(e.getCode() == KeyCode.ASTERISK) { 
		    		  multiply();
		    	  }
		    	  if(e.getCode() == KeyCode.BACK_SLASH) { 
		    		  divide();
		    	  }
		    	  if(e.getCode() == KeyCode.PLUS) { 
		    		  add();
		    	  }
		    	  if(e.getCode() == KeyCode.MINUS) { 
		    		  subtract();
		    	  }
		    	  if(e.getCode() == KeyCode.LEFT_PARENTHESIS) { 
		    		  openParenthesis();
		    	  }
		    	  if(e.getCode() == KeyCode.RIGHT_PARENTHESIS) { 
		    		  closedParenthesis();
		    	  }
		    	  if(e.getCode() == KeyCode.ENTER || e.getCode() == KeyCode.EQUALS) { 
		    		  equal();
		    	  }
		    	  if(e.getCode() == KeyCode.C) { 
		    		  clear();
		    	  }
		    	  if(e.getCode() == KeyCode.SHIFT) {
		    		  keyPressedShift();
		    	  }
		    	  if(e.getCode() == KeyCode.ESCAPE || e.getCode() == KeyCode.Q) {
		    		 quit();
		    	  }
		    	  e.consume();
		        }
		    });
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		keyPressedNormal();
		
	}
	
}
