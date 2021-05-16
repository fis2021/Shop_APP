package jpm.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jpm.model.Product;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import static jpm.Services.LoginService.*;
import static jpm.Services.UserService.updatebBalance;
import static jpm.controllers.MenuControllerBuyer.paneb;
import jpm.exceptions.NotEnoughtBalance;


public class ElementControllerBuyer implements Initializable {
    @FXML
    private Text Title;
    @FXML
    private Text Details;
    @FXML
    private Text Owner;
    @FXML
    private Text Price;
    @FXML
    private AnchorPane mainwindow;

    public void handleCloseMenu()
    {
        Stage stage = (Stage) paneb.getScene().getWindow();
        stage.close();
    }
    public static Product prod;
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
    public static void getProductB(Product newProduct)
    {
    prod = newProduct;
    }
    public void initialize(URL location, ResourceBundle resources) {


            Title.setText(prod.getProduct_name());
            Details.setText("Detalii : \n"+prod.getProduct_description());
            Owner.setText("Owner :"+prod.getOwner());
            Price.setText("Price :" + String.valueOf(prod.getPrice() + "lei"));


    }
    public void buy ()
    {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("buy.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage buy = new Stage();
        buy.setTitle("Shopp-App");
        buy.setScene(new Scene(root));
        buy.setResizable(false);
        buy.show();


    }


}
