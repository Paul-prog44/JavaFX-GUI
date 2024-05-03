package dataVisualization;

import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class DynamicData extends Application{
	public void start(Stage stage) {
		Random random = new Random();
		
		NumberAxis xAxis = new NumberAxis();
		NumberAxis yAxis = new NumberAxis(1, 6, 1);
		
		LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
		
		lineChart.setLegendVisible(false);
		lineChart.setAnimated(false);
		lineChart.setCreateSymbols(false);
		
		XYChart.Series average = new XYChart.Series<>();
		lineChart.getData().add(average);
		
		new AnimationTimer() {
			private long previous;
			private long sum;
			private long count;
			
			@Override
			public void handle(long current) {
				if (current - previous < 100_000_000L) {
					return;
				}
				
				previous = current;
				
				// roll dice
				int number = random.nextInt(6) + 1;
				
				sum +=number;
				count++;
				
				average.getData().add(new XYChart.Data(count, 1.0 * sum/count));
			}
		}.start();
		
		Scene scene = new Scene(lineChart, 400, 300);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(DynamicData.class);
	}
}
