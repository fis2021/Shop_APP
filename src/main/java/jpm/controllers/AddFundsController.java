package jpm.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.awt.*;
import java.io.IOException;

import static jpm.Services.LoginService.get_user;
import static jpm.Services.LoginService.set_balance;
import static jpm.Services.ProductService.loadProductsFromFile;
import static jpm.Services.UserService.updatebBalance;
import static jpm.controllers.MenuControllerBuyer.paneb;


import javafx.scene.control.TextField;



public class AddFundsController {
    @FXML
    private TextField funds;
    @FXML
    private AnchorPane mainwindow;


    public void handleClose() {
        Stage stage = (Stage) mainwindow.getScene().getWindow();
        stage.close();
    }
    public void handleCloseMenu()
    {
        Stage stage = (Stage) paneb.getScene().getWindow();
        stage.close();
    }

    public void refresh() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("MenuBuyer.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage menu_start = new Stage();
        menu_start.setTitle("Menu");
        menu_start.setScene(new Scene(root));
        menu_start.setResizable(false);
        menu_start.show();
    }
    public void updateFunds()
    {

        updatebBalance(get_user(), Float.parseFloat(funds.getText()));
        set_balance(Float.parseFloat(funds.getText()));
        handleClose();
        handleCloseMenu();
        refresh();
    }
}
