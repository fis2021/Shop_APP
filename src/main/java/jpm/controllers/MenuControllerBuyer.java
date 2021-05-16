package jpm.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jpm.Services.LoginService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuControllerBuyer implements Initializable {
    @FXML
    private AnchorPane Listpane;
    @FXML
    private AnchorPane mainwindow;
    @FXML
    private Text balance;
    @FXML
    public void handleClose() {
        Stage stage = (Stage) mainwindow.getScene().getWindow();
        stage.close();
    }

    public static AnchorPane paneb;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        balance.setText("Balance :"+ LoginService.get_balance());
         paneb = null;
        try {
            paneb = FXMLLoader.load(getClass().getClassLoader().getResource("list_holder.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Listpane.getChildren().setAll(paneb);
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
    public void add_funds()
    {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("add_funds.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage add_funds = new Stage();
        add_funds.setTitle("Shopp-App");
        add_funds.setScene(new Scene(root));
        add_funds.setResizable(false);
        add_funds.show();
    }
}
