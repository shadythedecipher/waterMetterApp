package com.watermetterapp.watermetterapp;

import backendIntegartion.userBackend;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class SignIn implements Initializable {
    public Label improperLogin;
    public TextField TextField1;
    public PasswordField passwordField;

    public SignIn(ApplicationContext context) {
        this.context = context;
    }

    ApplicationContext context;
    @FXML
    public VBox signInVbox;
    public Button singInButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void SingInAction(ActionEvent actionEvent) throws IOException {

     Boolean loggedIn= userBackend.loginUser(passwordField.getText(), TextField1.getText());
        if (loggedIn)
        {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
            fxmlLoader.setControllerFactory(context::getBean);
            Stagelistener.setRoot(fxmlLoader.load(),"dashboard",false);

        }
        else {
            improperLogin.setOpacity(1);

        }

    }

    public void showlabel(MouseEvent mouseEvent) {
        improperLogin.setOpacity(0);
    }
}
