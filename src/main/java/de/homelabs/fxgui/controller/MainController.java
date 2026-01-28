package de.homelabs.fxgui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import de.homelabs.fxgui.FxmlView;
import de.homelabs.fxgui.StageManager;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

@Component
public class MainController  {

    private final StageManager stageManager;

    @FXML
    private AnchorPane mainContainer;
    
	@Lazy
	public MainController(StageManager stageManager) {
		this.stageManager = stageManager; 
	}
	@FXML
	public void initialize(URL location, ResourceBundle resources) {    
		
	}
	
	public void loadAboutPage() {
		System.out.println("about Page");
		
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("About jxGui");
		alert.setHeaderText("About jxGui"); // oder null
		
		alert.setContentText("jxGui (2026)\nsmirk.mueller@gmail.com\n\n"
				+ "A demo application to get started with javafx and spring boot. "
				+ "Using the strengh from both frameworks to create rich user interfaces");
		alert.showAndWait();
		if (mainContainer != null) {
			System.out.println(mainContainer.getId());
			stageManager.switchContent(mainContainer, FxmlView.FORMVIEW);
		}
	}
}
