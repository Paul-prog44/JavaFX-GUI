package dataVisualization;

import java.text.DecimalFormat;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculator extends Application {
	
	public void start(Stage stage) {
		
		Label monthlySavingsText = new Label("Monthly savings");
		Label interestRateText = new Label("Yearly interest rates");
		
		
		Slider savingSlider = new Slider(25, 250, 100);
		Slider interestSlider = new Slider(0, 10, 5);
		
		Label currentValueSavings = new Label(""+ savingSlider.getValue());
		Label currentInterestRate = new Label(""+ interestSlider.getValue());
			    
	  //X and y axis
		NumberAxis xAxis = new NumberAxis(0, 30, 2);
	  	NumberAxis yAxis = new NumberAxis();
	  		
	  	LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
	  	lineChart.setTitle("Savings Calculator");
	  		
		savingSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
			lineChart.getData().clear();
			XYChart.Series savingsChart = new XYChart.Series();
			currentValueSavings.setText(""+newValue.intValue());
			for (int i = 0; i <31; i++) {
				savingsChart.getData().add(new XYChart.Data(i, i*newValue.intValue()*12));
			}
			
			lineChart.getData().add(savingsChart);
		});
		
		
		interestSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
			//Formatage du double à 2 chiffre après la virgule
			DecimalFormat df = new DecimalFormat("#.##");
			String formattedValue = df.format(newValue);
			currentInterestRate.setText(formattedValue);
			
			lineChart.getData().clear();
			XYChart.Series savingsChart = new XYChart.Series();
			for (int i = 0; i <31; i++) {
				savingsChart.getData().add(new XYChart.Data(i, savingSlider.getValue()*Math.pow((1.0 + newValue.doubleValue()/100), i)));
			}
			lineChart.getData().add(savingsChart);
		});

		
		savingSlider.setShowTickMarks(true);
		savingSlider.setShowTickLabels(true);
		
		interestSlider.setShowTickMarks(true);
		interestSlider.setShowTickLabels(true);
		//Permet l'affichage des %
		interestSlider.setMajorTickUnit(1.0);
		
		System.out.println(interestSlider.valueChangingProperty());

		BorderPane layout = new BorderPane();
		VBox vbox = new VBox();
		
		BorderPane monthlySavings = new BorderPane();
		BorderPane interestRate = new BorderPane();
		
		monthlySavings.setLeft(monthlySavingsText);
		monthlySavings.setCenter(savingSlider);
		monthlySavings.setRight(currentValueSavings);
		interestRate.setLeft(interestRateText);
		interestRate.setCenter(interestSlider);
		interestRate.setRight(currentInterestRate);
		

		vbox.getChildren().addAll(monthlySavings, interestRate);


	
		

		
		layout.setCenter(lineChart);
		layout.setTop(vbox);
		
		Scene view = new Scene(layout);
		stage.setScene(view);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(SavingsCalculator.class);
	}

}
