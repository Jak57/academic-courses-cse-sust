# Java-Project-01
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.geometry.Insets;


public class GitComparison extends Application{
    
    Stage window;
    Button button;
    
    public static void main(String args[]){
        launch(args);
    }
    
    public void start(Stage stage){
        window = stage;
        window.setTitle("GitHub Contribution Comparison");
        
        GridPane layout = new GridPane();
        layout.setPadding(new Insets(10, 10, 10, 10));
        
        layout.setVgap(8);
        layout.setHgap(10);
        
        Label label3 = new Label("WELCOME TO GITHUB CONTRIBUTION ANALYSIS");
       
        Label label4 = new Label("Pleade enter the username of two users: ");
        
        Label label1 = new Label("Username:");
        TextField username1 = new TextField();
        username1.setPromptText("username");
        
        Label label2 = new Label("Username:");
        TextField username2 = new TextField();
        username2.setPromptText("username");
        
        button = new Button("login");
        button.setOnAction(e -> ShowLineChart.display());
        
        
        
        GridPane.setConstraints(label3, 1, 0);
        GridPane.setConstraints(label4, 0, 1);
        GridPane.setConstraints(label1, 0, 2);
        GridPane.setConstraints(username1, 1, 2);
        GridPane.setConstraints(label2, 0, 3);
        GridPane.setConstraints(username2, 1, 3);
        GridPane.setConstraints(button, 0, 4);
        
        layout.getChildren().addAll(label3, label4, label1, username1, label2, username2, button);
        
        Scene scene = new Scene(layout, 700, 500);
        
        window.setScene(scene);
        window.show();
       
        
        
    }
}


*********
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ShowLineChart{
       
    public static void display(){
        Stage stage;
        stage = new Stage();
        
        stage.initModality(Modality.APPLICATION_MODAL);
        
        NumberAxis yAxis = new NumberAxis();
        CategoryAxis xAxis = new CategoryAxis();
        
        xAxis.setLabel("Month");
        
        LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);
        
        lineChart.setTitle("Contribution Comparison");
        
        XYChart.Series series1 = new XYChart.Series();
        
        series1.setName("User A");
        
        series1.getData().add(new XYChart.Data("January", 15));
        series1.getData().add(new XYChart.Data("February", 7));
        series1.getData().add(new XYChart.Data("March", 20));
        series1.getData().add(new XYChart.Data("April", 12));
        
        series1.getData().add(new XYChart.Data("May", 15));
        series1.getData().add(new XYChart.Data("June", 5));
        series1.getData().add(new XYChart.Data("July", 10));
        series1.getData().add(new XYChart.Data("August", 16));
        
        series1.getData().add(new XYChart.Data("September", 13));
        series1.getData().add(new XYChart.Data("October", 8));
        series1.getData().add(new XYChart.Data("November", 10));
        series1.getData().add(new XYChart.Data("December", 16));
        
        
        
        XYChart.Series series2 = new XYChart.Series();
        
        series2.setName("User B");
        
       
        series2.getData().add(new XYChart.Data("January", 10));
        series2.getData().add(new XYChart.Data("February", 9));
        series2.getData().add(new XYChart.Data("March", 16));
        series2.getData().add(new XYChart.Data("April", 20));
        
        series2.getData().add(new XYChart.Data("May", 18));
        series2.getData().add(new XYChart.Data("June", 17));
        series2.getData().add(new XYChart.Data("July", 30));
        series2.getData().add(new XYChart.Data("August", 22));
        
        series2.getData().add(new XYChart.Data("September", 25));
        series2.getData().add(new XYChart.Data("October", 17));
        series2.getData().add(new XYChart.Data("November", 23));
        series2.getData().add(new XYChart.Data("December", 22));
        
        
        Scene scene = new Scene(lineChart, 800, 500);
        
        lineChart.getData().addAll(series1, series2);
        
        stage.setScene(scene);
        stage.show();
        
        
        
    }
}


