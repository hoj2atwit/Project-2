import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class CalculatorController extends Calculator {
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
	
	public void equals() {
		calculate();
		update();
	}

}
