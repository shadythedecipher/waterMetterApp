package com.watermetterapp.watermetterapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class HelloController implements Initializable {

    final Float[] values = new Float[] {-1.0f, 0f, 0.6f, 1.0f};
    final Label [] labels = new Label[values.length];
//    @FXML
//    ProgressBar[] pbs = new ProgressBar[values.length];
    @FXML
    static ProgressBar pbs = new ProgressBar();
   @FXML
    final ProgressIndicator[] pins = new ProgressIndicator[values.length];

    String url = "http://localhost:8080/getuser";
    RestTemplate template= new RestTemplate();
    public HelloController(ApplicationContext context) {

        this.context = context;
      // UpdateBar();

    }
//    public void UpdateBar()
//    {
//        for (int i=0;i< values.length;i++) {
//         ProgressBar pb = pbs[i] = new ProgressBar();
//            pb.setProgress(values[i]);
////            final ProgressIndicator pin = pins[i] = new ProgressIndicator();
////            pin.setProgress(values[i]);
//        }
//
//    }


    ApplicationContext context;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() throws IOException {
//        String greetings=  template.getForObject(url,String.class);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tesing.fxml"));
        fxmlLoader.setControllerFactory(context::getBean);
        Stagelistener.setRoot(fxmlLoader.load(),"Welcome", true);
//        welcomeText.setText(greetings);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}