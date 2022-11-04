package com.watermetterapp.watermetterapp;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class Tesing implements Initializable {
    public Tesing(ApplicationContext context) {
        this.context = context;
    }

    ApplicationContext context;

    public Label label;
    @FXML
    public VBox vboxTra;
    public ImageView imgview;
    public Button signInButton;
    public Button signUpButton;

    public void transition()
     {
         FadeTransition trans = new FadeTransition(Duration.seconds(2), vboxTra);
         trans.setFromValue(1.0);
         trans.setToValue(0);
         // Let the animation run forever
         trans.setCycleCount(FadeTransition.INDEFINITE);
         // Reverse direction on alternating cycles
         trans.setAutoReverse(true);
         // Play the Animation
         trans.play();
     }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        transition();
    }

    public void goToSignInPage(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("signIn.fxml"));
        fxmlLoader.setControllerFactory(context::getBean);
        Stagelistener.setRoot(fxmlLoader.load(),"SignIn page",true);
    }

    public void goToSignUpPage(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("singUp.fxml"));
        fxmlLoader.setControllerFactory(context::getBean);
        Stagelistener.setRoot(fxmlLoader.load(),"SignUp page",false);
    }
}
