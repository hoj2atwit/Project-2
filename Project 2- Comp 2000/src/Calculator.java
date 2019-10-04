import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Calculator extends Application{
	
	private String infix = "";
	private boolean hasAnswer = false;
	private static String errorMessage;
	public static void main(String[] args){
		launch(args);
	}
	
	public void start(Stage stage) throws Exception {
		//Shows main menu screen
				Parent root = FXMLLoader.load(getClass().getResource("CalculatorGUI.fxml")); 
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
				stage.setResizable(false);
	}
	
	public static void error(String s) {
		setErrorMessage(s);
	}

	public String getInfix() {
		return infix;
	}

	public void setInfix(String infix) {
		this.infix = infix;
	}
	
	public void input(String s) {
		setErrorMessage("");
		if(!hasAnswer) {
			if(getInfix().length() < 25) {
				infix = infix + s;
			}else {
				setErrorMessage("Reached Maximum Characters Allowed.");
			}	
		}else {
			setErrorMessage("Clear before starting a new equation.");
		}
	}
	
	public void calculate() {
		setErrorMessage("");
		try {
			// Converts infix to postfix and saves string to temp
			String temp = infixToPostfix.convert(getInfix());
			
			double ans = PostfixEvaluator.calculate(temp);
			
			// Holds answer as string for formatting decimal places
			String ansString;
			if(ans%1==0) {
				ansString = String.format("%.0f", ans);
			}else {
				ansString = String.format("%f", ans);
				int latestZero = 0;
				boolean foundZero = false;
				
				//Removes any extra zero's that are remaining in decimal
				for(int i = 0; i < ansString.length(); i++) {
					//Starts checking after decimal
					if(ansString.charAt(i) == '.') {
						for(int j = i+1; j < ansString.length(); j++) {
							if(ansString.charAt(j) == '0' && !foundZero) {
								latestZero = j;
								foundZero = true;
							}else if(!(ansString.charAt(j) == '0')){
								latestZero = 0;
								foundZero = false;
							}
						}
						break;
					}
				}
				
				//Removes extra 0's
				if(latestZero != 0 && foundZero) {
					ansString = ansString.substring(0, latestZero);
					if(ansString.substring(ansString.length()-1).equals(".")) {
						ansString = "~" + ansString.substring(0,ansString.length()-1);
					}
				}
			}
			
			setInfix(ansString);
			setHasAnswer(true);
		}catch(Exception e) {
		}
	}

	public boolean isHasAnswer() {
		return hasAnswer;
	}

	public void setHasAnswer(boolean hasAnswer) {
		this.hasAnswer = hasAnswer;
	}

	public static String getErrorMessage() {
		return errorMessage;
	}

	public static void setErrorMessage(String errorMessage) {
		Calculator.errorMessage = errorMessage;
	}

	
}

