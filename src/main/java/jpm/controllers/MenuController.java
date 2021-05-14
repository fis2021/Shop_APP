package jpm.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.scene.control.*;
public class MenuController implements Initializable {
    @FXML
    private AnchorPane Listpane;
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(getClass().getClassLoader().getResource("list_holder.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Listpane.getChildren().setAll(pane);
    }
}
