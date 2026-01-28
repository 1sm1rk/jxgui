package de.homelabs.fxgui;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import javafx.application.Application;

@SpringBootApplication
public class JxguiApplication {

	public static void main(String[] args) {
		//SpringApplication.run(JxguiApplication.class, args);
		Application.launch(MainApplication.class, args);
	}

}
