package com.watermetterapp.watermetterapp;

import com.EntitiesAPP.mainuser;
import backendIntegartion.userBackend;
import javafx.event.ActionEvent;
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
import java.util.Objects;
import java.util.ResourceBundle;

@Component
public class SingUp implements Initializable {

    public PasswordField singUpPassword;
    public TextField email;
    public TextField second_name;
    public TextField first_name;
    public Label labelWrongInput;

    public SingUp(ApplicationContext context) {
        this.context = context;
    }

    ApplicationContext context;
    public VBox vbox;
    public Button button;
    public Button singUPButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }

    public void SingUpAction(ActionEvent actionEvent) throws IOException {
        mainuser obj = new mainuser();
        obj.setFirstName(first_name.getText());
        obj.setUserName(second_name.getText());
        obj.setEmail(email.getText());
        obj.setUserPassword(singUpPassword.getText());

        String nameF= obj.getFirstName();
        String nameS= obj.getUserName();
        String Email= obj.getEmail();
        String pass= obj.getUserPassword();
        if (!Objects.equals(nameF, "")&& !Objects.equals(nameS, "")&& !Objects.equals(Email, "")&& !Objects.equals(pass, ""))
        {
            userBackend userBackendServ= new userBackend();
            userBackendServ.saveUser(obj);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("signIn.fxml"));
            fxmlLoader.setControllerFactory(context::getBean);
            Stagelistener.setRoot(fxmlLoader.load(),"signIn Page",false);

        }
        else {
            labelWrongInput.setOpacity(1);

        }


    }

    public void disablelabel(MouseEvent mouseEvent) {
        labelWrongInput.setOpacity(0);
    }
}
