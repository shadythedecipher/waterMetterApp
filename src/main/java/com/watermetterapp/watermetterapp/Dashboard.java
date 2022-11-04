package com.watermetterapp.watermetterapp;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Dashboard {
    ApplicationContext context;

    public Dashboard(ApplicationContext context) {
        this.context = context;
    }

    public Button btn;

    public void goToMetersInformation(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("meterInfo.fxml"));
        fxmlLoader.setControllerFactory(context::getBean);
        Stagelistener.setRoot(fxmlLoader.load(),"Meter Information",true);
    }
}
