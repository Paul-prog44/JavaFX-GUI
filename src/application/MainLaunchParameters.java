package application;

import java.util.Scanner;

import javafx.application.Application;

public class MainLaunchParameters {
	
	public static void main(String[] args) {
		
		System.out.println("Choose a title");
		Scanner scanner = new Scanner(System.in);
		String title = scanner.nextLine();
		
		Application.launch(LaunchParameters.class,
				"--title="+title);
	}
}
