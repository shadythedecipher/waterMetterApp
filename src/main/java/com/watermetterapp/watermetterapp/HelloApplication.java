package com.watermetterapp.watermetterapp;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
@SpringBootApplication
public class HelloApplication extends Application {
    private ConfigurableApplicationContext configurableApplicationContext;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void init() throws Exception {
        super.init();
        configurableApplicationContext= new SpringApplicationBuilder(HelloApplication.class).run();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        configurableApplicationContext.publishEvent(new StageReadyEVent(primaryStage));

    }

    @Override
    public void stop() throws Exception {
        super.stop();
        configurableApplicationContext.close();
        Platform.exit();
    }

    public static class StageReadyEVent extends ApplicationEvent {
        public StageReadyEVent(Stage primaryStage) {
            super(primaryStage);
        }
        public Stage getStage(){
            return (Stage)getSource();
        }
    }

}