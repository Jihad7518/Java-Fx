package application;
	
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.layout.*;


public class CircleShow extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane pane = new GridPane();
			pane.setAlignment(Pos.CENTER);
			pane.setPadding(new Insets(10, 10, 10, 10));
			pane.setHgap(5);
			pane.setVgap(5);
			
			//Circle c1 = new Circle(20);
			//c1.setFill(Color.BLUE);
			
			Circle c1 = new Circle(20);
			//c1.setFill(Color.RED);
			
			
			
			pane.add(c1, 0, 0);
			//pane.add(c2, 1, 0);
			
			Button switchCircle = new Button("Switch Circle");
			GridPane gridPane = new GridPane();
			gridPane.add(switchCircle, 0, 4);
			
			GridPane.setHalignment(switchCircle, HPos.RIGHT);
			
			Scene scene = new Scene(pane, 200, 200);
			
			
			primaryStage.setTitle("Switch Circle and Rectangle");
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
