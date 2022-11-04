package com.watermetterapp.watermetterapp;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

@Component
public class Stagelistener implements ApplicationListener<HelloApplication.StageReadyEVent> {
    public static Stage stage;

    private final ApplicationContext context;
//    @Value("E:/mashineapp/src/main/resources/home.fxml")
//    private Resource resource;

    public Stagelistener(ApplicationContext context) {
        this.context = context;
    }



    public static void setRoot(Parent root,String name, Boolean resizable) {
        if(Objects.equals(name, "dashboard")) {
            Scene scene1 = new Scene(root, 800, 624);
            stage.setScene(scene1);
            stage.setResizable(resizable);
//        stage.setFullScreen(resizable);
            stage.setWidth(1100);
            stage.setTitle(name);
        }
        else {
            Scene scene1 = new Scene(root, 800, 624);
            stage.setScene(scene1);
            stage.setResizable(resizable);
//        stage.setFullScreen(resizable);
            stage.setTitle(name);
        }
    }


    @Override
    public void onApplicationEvent(HelloApplication.StageReadyEVent event) {

        try {
            stage= event.getStage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
           fxmlLoader.setControllerFactory(context::getBean);
            Parent root=fxmlLoader.load();
            Scene scene = new Scene(root, 800, 624);
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.setWidth(800);
            stage.setHeight(624);
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
