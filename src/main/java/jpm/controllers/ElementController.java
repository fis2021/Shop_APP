package jpm.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import jpm.model.Product;
import static jpm.Services.ProductService.removeProduct;
import static jpm.Services.ProductService.editProduct;
import static jpm.controllers.MenuController.pane;


public class ElementController implements Initializable {
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
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.close();
    }
    public static Product prod;
    public void refresh() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("MenuSeller.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage menu_start = new Stage();
        menu_start.setTitle("Menu");
        menu_start.setScene(new Scene(root));
        menu_start.setResizable(false);
        menu_start.show();
    }
    public static void getProduct(Product newProduct)
    {
    prod = newProduct;
    }
    public void remove_Product()
    {
        removeProduct(ElementController.prod);
        handleCloseMenu();
        refresh();

    }

    public void edit_Product()
    {

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("edit_product.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage edit_product = new Stage();
        edit_product.setTitle("Shopp-App");
        edit_product.setScene(new Scene(root));
        edit_product.setResizable(false);
        edit_product.show();
    }
    public void initialize(URL location, ResourceBundle resources) {


            Title.setText(prod.getProduct_name());
            Details.setText("Detalii : \n"+prod.getProduct_description());
            Owner.setText("Owner :"+prod.getOwner());
            Price.setText("Price :" + String.valueOf(prod.getPrice() + "lei"));


    }


}
