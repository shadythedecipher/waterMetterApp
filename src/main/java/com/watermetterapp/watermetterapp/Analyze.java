package com.watermetterapp.watermetterapp;

import com.EntitiesAPP.meter;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

@Component
public class Analyze implements Initializable {
    public TableView<meter> meterTable;
    public TableColumn<meter, Long> meterNo;
    public TableColumn <meter, String>ownerName;
    public TableColumn<meter, String> Address;
    public TableColumn<meter, String> billingInfo;
    public TableColumn <meter,String>usage;
    public TableColumn<meter, Date> date;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
