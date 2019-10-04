import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController  extends Calculator implements Initializable{
	@FXML
	private Button quitButton;
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
	private TextField operationTextField;
		
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void update() {
		operationTextField.setText(getInfix());
	}
	
	public void divide() {
		if(!getInfix().equals("")) {
			setInfix(String.format("%s/", getInfix()));
		}
		update();
	}
	
	public void multiply() {
		if(!getInfix().equals("")) {
			setInfix(String.format("%s*", getInfix()));
		}
		update();
	}

	public void add() {
		if(!getInfix().equals("")) {
			setInfix(String.format("%s+", getInfix()));
		}
		update();
	}
	
	public void subtract() {
		if(!getInfix().equals("")) {
			setInfix(String.format("%s-", getInfix()));
		}
		update();
	}
	
	public void one() {
		if(!getInfix().equals("")) {
			setInfix(String.format("%s1", getInfix()));
		}
		update();
	}
	public void two() {
		if(!getInfix().equals("")) {
			setInfix(String.format("%s2", getInfix()));
		}
		update();
	}
	public void three() {
		if(!getInfix().equals("")) {
			setInfix(String.format("%s3", getInfix()));
		}
	}
	public void four() {
		if(!getInfix().equals("")) {
			setInfix(String.format("%s4", getInfix()));
		}
		update();
	}
	public void five() {
		if(!getInfix().equals("")) {
			setInfix(String.format("%s5", getInfix()));
		}
		update();
	}
	public void six() {
		if(!getInfix().equals("")) {
			setInfix(String.format("%s6", getInfix()));
		}
		update();
	}
	public void seven() {
		if(!getInfix().equals("")) {
			setInfix(String.format("%s7", getInfix()));
		}
	}
	public void eight() {
		if(!getInfix().equals("")) {
			setInfix(String.format("%s8", getInfix()));
		}
		update();
	}
	public void nine() {
		if(!getInfix().equals("")) {
			setInfix(String.format("%s9", getInfix()));
		}
		update();
	}
	public void zero() {
		if(!getInfix().equals("")) {
			setInfix(String.format("%s0", getInfix()));
		}
		update();
	}
	
	public void openParenthesis() {
		if(!getInfix().equals("")) {
			setInfix(String.format("%s(", getInfix()));
		}
		update();
	}
	
	public void closedParenthesis() {
		if(!getInfix().equals("")) {
			setInfix(String.format("%s)", getInfix()));
		}
		update();
	}
	
	public void clear() {
		setInfix("");
		update();
	}
	
	public void delete() {
		setInfix(getInfix().substring(0, getInfix().length()-1));
		update();
	}
	
	public void quit() {
		System.exit(0);
	}
	
}
