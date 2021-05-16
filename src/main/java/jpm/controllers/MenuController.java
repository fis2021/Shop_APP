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
    @FXML
    private AnchorPane mainwindow;
    @FXML
    public void handleClose() {
        Stage stage = (Stage) mainwindow.getScene().getWindow();
        stage.close();
    }

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
    public void sing_out()
    {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage backtologin = new Stage();
        backtologin.setScene(new Scene(root));
        backtologin.setResizable(false);
        handleClose();
        backtologin.show();
    }
    public void add_product()
    {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("add_product.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage add_product = new Stage();
        add_product.setTitle("Shopp-App");
        add_product.setScene(new Scene(root));
        add_product.setResizable(false);
        add_product.show();
    }
}
