package com.watermetterapp.watermetterapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MeterInfo {
    public MeterInfo(ApplicationContext context) {
        this.context = context;
    }

    private ApplicationContext context;

    public void AddMetterInformation(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Addmeter.fxml"));
        fxmlLoader.setControllerFactory(context::getBean);
        Stagelistener.setRoot(fxmlLoader.load(),"Add meter", true);
    }

    public void AnalzyeMeterInfo(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Analyze.fxml"));
        fxmlLoader.setControllerFactory(context::getBean);
        Stagelistener.setRoot(fxmlLoader.load(),"Analyze meters", true);
    }
}
