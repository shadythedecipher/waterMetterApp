package com.watermetterapp.watermetterapp;
import com.EntitiesAPP.meter;
import backendIntegartion.userBackend;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

@Component
public class addmetterController {
    public TextField accNum;
    public TextField ownerInfo;
    public TextField phoneNumber;
    public TextField readingType;
    public TextField meterUsage;

    public Label labelWrongInput;
    public VBox signInVbox;

    public addmetterController(ApplicationContext context) {
        this.context = context;
    }

    ApplicationContext context;
    public Button AddMeterAndreturnToDashboard;

    public void returnDashBoard(ActionEvent actionEvent) throws IOException {
        meter obj = new meter();
        obj.setAccNo(Long.valueOf(accNum.getText()));
        obj.setOwnerName(ownerInfo.getText());
        obj.setPhoneNumber(phoneNumber.getText());
        obj.setReadingType(this.readingType.getText());
        obj.setMeterUser(meterUsage.getText());

        String accNo = String.valueOf(obj.getAccNo());
        String meterUser = obj.getMeterUser();
        String phoneNo = obj.getPhoneNumber();
        String readingType = obj.getReadingType();
        String meterUsage= obj.getMeterUserUsage();
        if (!Objects.equals(accNo, "")&& !Objects.equals(meterUser, "")&& !Objects.equals(phoneNo, "")&& !Objects.equals(readingType, "")&& !Objects.equals(meterUsage, ""))
        {
            userBackend userBackendServ= new userBackend();
           String action= String.valueOf(userBackendServ.addMeter(obj));
            System.out.println(action);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("meterInfo.fxml"));
            fxmlLoader.setControllerFactory(context::getBean);
            Stagelistener.setRoot(fxmlLoader.load(),"Meter Information", true);

        }
        else {
            labelWrongInput.setOpacity(1);

        }

    }
}
