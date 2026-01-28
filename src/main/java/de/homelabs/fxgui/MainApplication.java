package de.homelabs.fxgui;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * 
 * Links:
 * - https://bell-sw.com/blog/creating-modern-desktop-apps-with-javafx-and-spring-boot/
 * - https://bell-sw.com/blog/javafx-guide-go-graphical-with-java/#mcetoc_1ika7tt9kc5
 */
public class MainApplication extends Application {

	private static Stage stage;
	private double x=0;
	private double y=0;
	
    private ConfigurableApplicationContext applicationContext;
    private StageManager stageManager;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		stage = primaryStage;
        stageManager = applicationContext.getBean(StageManager.class, primaryStage);
        Scene scene = stage.getScene();
        //EventHandler<MouseEvent> handler;
        scene.setOnMousePressed( handler -> {
        	this.x = handler.getSceneX();
        	this.y = handler.getSceneY();
        });
        
        scene.setOnMouseDragged( handler -> {
        	stage.setX(handler.getSceneX() -x);
        	stage.setY(handler.getSceneY() -y);
        	
        	stage.setOpacity(.8);
        });
        
        scene.setOnMouseReleased( handler -> {
        	stage.setOpacity(1);
        });
        showHomepage();
	}

	@Override
	public void init() throws Exception {
		applicationContext = new SpringApplicationBuilder(JxguiApplication.class).run();
	}

	@Override
	public void stop() throws Exception {
		applicationContext.close();
		stage.close();
	}

	private void showHomepage() {
		stageManager.switchScene(FxmlView.HOME);
	}
	
}
