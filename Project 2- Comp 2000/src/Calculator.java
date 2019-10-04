import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Calculator extends Application{
	
	private String infix = "";
	
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

	public String getInfix() {
		return infix;
	}

	public void setInfix(String infix) {
		this.infix = infix;
	}
	
}

