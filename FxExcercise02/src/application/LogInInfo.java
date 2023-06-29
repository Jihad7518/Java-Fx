package application;
	
import java.awt.Insets;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.*;


public class LogInInfo extends Application {
	public static TextField txtUserName; 
	public static TextField txtPassword;
	public static TextField txtName;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			
			root.setTop(new Label("Login Form"));
			
			GridPane gridpane = new GridPane();
			gridpane.setPadding(new javafx.geometry.Insets(10, 10, 10, 10));
			gridpane.setHgap(20);
			gridpane.setVgap(20);
			
			
			
			
			Label lblusername = new Label("User Name");
			Label lblpasssword = new Label("PassWord");
			
			txtUserName = new TextField();
			txtPassword = new PasswordField();
			
			txtName = new TextField();
			
			Button btnsubmit = new Button("Submit");
			
			gridpane.add(lblusername, 0, 0);
			gridpane.add(txtUserName, 1, 0);
			gridpane.add(lblpasssword, 0, 1);
			gridpane.add(txtPassword, 1, 1);
			gridpane.add(btnsubmit, 1, 2);
			
			
			gridpane.setHalignment(btnsubmit, HPos.RIGHT);
			
			
			root.setCenter(gridpane);
			
			SubmitHandlerClass handler1 = new SubmitHandlerClass();
			
			btnsubmit.setOnAction(handler1);
			
			gridpane.add(txtName, 0, 3);
			txtName.setEditable(false);
			
			Scene scene = new Scene(root,400,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
