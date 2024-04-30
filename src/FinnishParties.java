import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class FinnishParties extends Application {
	private HashMap<String, Map<Integer, Integer>> values = new HashMap<>();
	private int year = 2006;

	@Override
	public  void start(Stage stage) {
		try (Scanner scanner = new Scanner(Paths.get("dataVisualization.txt"))) {
			while (scanner.hasNextLine()) {
				//Read each line
		        String row = scanner.nextLine();
		        //split each line into list
		        String[] pieces = row.split("\t");
		        HashMap<Integer,Integer> annualValues = new HashMap<>();
		        for (int i = 1; i<pieces.length; i++) {
		        	annualValues.put(year, Integer.valueOf(pieces[i]));
		        	year++;
		        }
		        values.put(pieces[0], annualValues);
		        year = 2006;
		        
		    }
			
		} catch (Exception e) {
		    System.out.println("Error: " + e.getMessage());
		}
		
				
		NumberAxis xAxis = new NumberAxis(2006, 2017, 4);
		NumberAxis yAxis = new NumberAxis();
		
		xAxis.setLabel("Year");
	    yAxis.setLabel("Relative support (%)");
	    
	    LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
	    lineChart.setTitle("Relative support of the parties");
	    
	    values.keySet().stream().forEach(party -> {
	    	XYChart.Series data = new XYChart.Series();
	    	data.setName(party);
	    	
	    	values.get(party).entrySet().stream().forEach(pair -> {
	    		data.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
	    	});
	    	
	    	lineChart.getData().add(data);
	    });
	    
	    Scene view = new Scene(lineChart, 640, 480);
	    stage.setScene(view);
	    stage.show();
	}
	
	public static void main(String[] args) {
		launch(FinnishParties.class);
	}
}
