open module com.watermetterapp.watermetterapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.context;
    requires  spring.web;
    requires  spring.boot.autoconfigure;
    requires  spring.boot;
   requires org.apache.tomcat.embed.core;

    exports com.watermetterapp.watermetterapp;
    exports com.EntitiesAPP;
}