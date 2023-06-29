package application;

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

/* @author
* @mdjihad75
* 
*/


public class App_2020_3_60_087 extends Application {

    private static Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception {
    	//BorderPane root = new BorderPane();
    	//root.setTop(new Label("Student GPA Calculator"));
    	
        primaryStage.setTitle("Students GPA Calculation");
        GridPane gridPane = createRegistrationFormPane();

        addUIControls(gridPane);

        Scene scene = new Scene(gridPane, 1000, 500);

        primaryStage.setScene(scene);
        
        primaryStage.show();
    }


    private GridPane createRegistrationFormPane() {
        GridPane gridPane = new GridPane();

        gridPane.setAlignment(Pos.CENTER);

        gridPane.setPadding(new Insets(40, 40, 40, 40));

        gridPane.setHgap(10);

        gridPane.setVgap(10);


        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }

    private void addUIControls(GridPane gridPane) {

        Label headerLabel = new Label("Students GPA Calculation");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));


        Label studentRoll = new Label("Student Roll No : ");
        //studentRoll.setPrefHeight(40);
        
        gridPane.add(studentRoll, 0,0);
        //GridPane.setHalignment(studentRoll, HPos.CENTER);


        TextField studentRollField = new TextField();
        //studentRollField.setPrefHeight(40);
        //studentRollField.setPrefWidth(10);
        gridPane.add(studentRollField, 1,0);
        //GridPane.setHalignment(studentRollField, HPos.CENTER);
        


        Label studentName = new Label("Student Name : ");
        gridPane.add(studentName, 0, 1);

        TextField studentNameField = new TextField();
        //studentNameField.setPrefHeight(40);
        gridPane.add(studentNameField, 1, 1);


        Label benLabel = new Label("Marks in Bengali : ");
        gridPane.add(benLabel, 0, 2);

        TextField benField = new TextField();
        //benField.setPrefHeight(40);
        gridPane.add(benField, 1, 2);


        Label engLabel = new Label("Marks in English : ");
        gridPane.add(engLabel, 0, 3);

        TextField engField = new TextField();
        //engField.setPrefHeight(40);
        gridPane.add(engField, 1, 3);

        Label mathLabel = new Label("Marks in Mathmatics : ");
        gridPane.add(mathLabel, 0, 4);

        TextField mathField = new TextField();
        //mathField.setPrefHeight(40);
        gridPane.add(mathField, 1, 4);


        Button calcGPA = new Button("Calculate GPA");
        //calcGPA.setPrefHeight(40);
       calcGPA.setDefaultButton(true);
        //calcGPA.setPrefWidth(300);
        gridPane.add(calcGPA, 1, 6);
        GridPane.setHalignment(calcGPA, HPos.RIGHT);
        //GridPane.setMargin(calcGPA, new Insets(20, 0,20,400));






        Label gradeAvgPoint = new Label("Grade Point Average : ");
        gridPane.add(gradeAvgPoint, 0,8);


        TextField gradeAvgPointField = new TextField();
        gridPane.add(gradeAvgPointField, 1,8);

        

        Button saveData = new Button("Save Data");
        saveData.setPrefHeight(40);
        saveData.setDefaultButton(true);
        saveData.setPrefWidth(300);
        gridPane.add(saveData, 1, 10);
        GridPane.setHalignment(saveData, HPos.RIGHT);
        GridPane.setMargin(saveData, new Insets(20, 0,20,400));


        Button refresh = new Button("Refresh Data");
        //refresh.setPrefHeight(40);
        refresh.setDefaultButton(true);
        gridPane.add(refresh,0, 12);
        GridPane.setHalignment(refresh, HPos.CENTER);

        Button closeFile = new Button("Close File");
        //closeFile.setPrefHeight(40);
        closeFile.setDefaultButton(true);
        gridPane.add(closeFile,1, 12);
        GridPane.setHalignment(closeFile, HPos.RIGHT);
        //GridPane.setMargin(closeFile, new Insets(20, 0, 20, 400));

        calcGPA.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    Integer bengaliMark = Integer.parseInt(benField.getText().toString());
                    Integer englishMark = Integer.parseInt(engField.getText().toString());
                    Integer mathMark = Integer.parseInt(mathField.getText().toString());

                
                float result = Calculator_2020_3_60_087.calculateGPA(bengaliMark, englishMark, mathMark);


                gradeAvgPointField.setText(""+result);

                
           }
        });


closeFile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
             Stage stage = (Stage) closeFile.getScene().getWindow();
            stage.close();
                
           }
        });

        refresh.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               
                studentRollField.setText("");
                 engField.setText("");
                   benField.setText("");
                    mathField.setText("");
                     studentNameField.setText("");
                     gradeAvgPointField.setText("");
           }
        });



        saveData.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                            String roll = studentRollField.getText().toString();
                            String bMarks = benField.getText().toString();
                            String eMarks = engField.getText().toString();
                            String mMarks = mathField.getText().toString();
                            String name = studentNameField.getText().toString();



                    Student_2020_3_60_087 s = new Student_2020_3_60_087(roll, name, Integer.parseInt(bMarks), Integer.parseInt(eMarks), Integer.parseInt(mMarks));

                    SaveDataToFile_2020_3_60_087.WriteObjectToFile(s);

                   }
                });
    }

    public static void main(String[] args) {
        launch(args);
    }

}