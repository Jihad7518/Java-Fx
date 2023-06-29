package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Salary extends Application {

	
	private static Scene scene;

	@Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("SALARY CALCULATOR");
        primaryStage.setMaximized(true);
        GridPane gridPane = createRegistrationFormPane();

        addUIControls(gridPane);

        Scene scene = new Scene(gridPane, 100, 50);

        primaryStage.setScene(scene);
        
        primaryStage.show();
    }


    private GridPane createRegistrationFormPane() {
        GridPane gridPane = new GridPane();

        gridPane.setAlignment(Pos.CENTER);

        gridPane.setPadding(new Insets(10, 10, 10, 10));

        gridPane.setHgap(3);

        gridPane.setVgap(3);


        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }

    private void addUIControls(GridPane gridPane) {

        Label headerLabel = new Label("Salary Calculator");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));


        Label nameLabel = new Label("Employee Name : ");
        gridPane.add(nameLabel, 0,1);


        TextField nameField = new TextField();
        nameField.setPrefHeight(50);
        nameField.setPrefWidth(10);
        gridPane.add(nameField, 1,1);


        Label basicLabel = new Label("Basic Salary : ");
        gridPane.add(basicLabel, 0, 2);

        TextField basicField = new TextField();
        basicField.setPrefHeight(50);
        basicField.setPrefWidth(10);
        gridPane.add(basicField, 1, 2);


        Label medLabel = new Label("Medical Allowance : ");
        gridPane.add(medLabel, 0, 3);

        TextField medField = new TextField();
        medField.setPrefHeight(50);
        medField.setPrefWidth(10);
        gridPane.add(medField, 1, 3);


        Button grossCalc = new Button("Calculate Gross Salary");
        grossCalc.setPrefHeight(50);
        grossCalc.setDefaultButton(true);
        grossCalc.setPrefWidth(300);
    
        gridPane.add(grossCalc, 0, 4, 2, 1);
        GridPane.setHalignment(grossCalc, HPos.RIGHT);
        GridPane.setMargin(grossCalc, new Insets(20, 0,20,400));


        Label houseLabel = new Label("House Rent : ");
        gridPane.add(houseLabel, 0,5);


        Label houseRentValueLabel = new Label("   ");
        gridPane.add(houseRentValueLabel, 1,5);


        Label grossLabel = new Label("Gross Salary : ");
        gridPane.add(grossLabel, 0, 6);


        Label grossSalaryValueLabel = new Label("");
        gridPane.add(grossSalaryValueLabel, 1, 6);

        Label taxLabel = new Label("Advance Tax : ");
        gridPane.add(taxLabel, 0, 7);

        TextField taxField = new TextField();
        taxField.setPrefHeight(50);
        taxField.setPrefWidth(10);
        gridPane.add(taxField, 1, 7);

        Button calcNetSalary = new Button("Calculate Net Salary");
        calcNetSalary.setPrefHeight(50);
        calcNetSalary.setDefaultButton(true);
        calcNetSalary.setPrefWidth(300);
        gridPane.add(calcNetSalary, 0, 6, 10, 50);
        GridPane.setHalignment(calcNetSalary, HPos.RIGHT);
        GridPane.setMargin(calcNetSalary, new Insets(20, 0,20,400));


        Label netLabel = new Label("Net Salary:");
        netLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 24));
        netLabel.setMinWidth(Region.USE_PREF_SIZE);
        gridPane.add(netLabel,1, 7, 10, 50);
        
        grossCalc.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    String baseSalary = basicField.getText().toString();
                    String medAllowance = medField.getText().toString();
                    String houseRent = ""+(Integer.parseInt(baseSalary)) * .5;
                    String gross = String.valueOf(Float.parseFloat(houseRent) + Integer.parseInt(baseSalary) + Integer.parseInt(medAllowance)); 
                    houseRentValueLabel.setText(houseRent);
                    grossSalaryValueLabel.setText(""+gross);
           }
        });


        calcNetSalary.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                            String baseSalary = basicField.getText().toString();
                            String medAllowance = medField.getText().toString();
                            String houseRent = ""+(Integer.parseInt(baseSalary)) * .5;
                            String gross = String.valueOf(Float.parseFloat(houseRent) + Integer.parseInt(baseSalary) + Integer.parseInt(medAllowance)); 
                            Float tax = (float) Integer.parseInt(taxField.getText().toString()) / 100;
                            Float net = Float.parseFloat(gross) - (Float.parseFloat(gross) * tax);
                           netLabel.setText("Net Salary: "+net);
                   }
                });
    }

    public static void main(String[] args) {
        launch(args);
    }


}
