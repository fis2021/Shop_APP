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
import jpm.model.Product;
import static jpm.Services.ProductService.removeProduct;
import static jpm.Services.ProductService.editProduct;


public class ElementController implements Initializable {
    @FXML
    private Text Title;
    @FXML
    private Text Details;
    @FXML
    private Text Owner;
    @FXML
    private Text Price;
    public static Product prod;
    public static void getProduct(Product newProduct)
    {
    prod = newProduct;
    }
    public void remove_Product()
    {
        removeProduct(ElementController.prod);
    }
    public void edit_Product()
    {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("edit_product.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage add_product = new Stage();
        add_product.setTitle("Shopp-App");
        add_product.setScene(new Scene(root));
        add_product.setResizable(false);
        add_product.show();
    }
    public void initialize(URL location, ResourceBundle resources) {


            Title.setText(prod.getProduct_name());
            Details.setText("Detalii : \n"+prod.getProduct_description());
            Owner.setText("Owner :"+prod.getOwner());
            Price.setText("Price :" + String.valueOf(prod.getPrice() + "lei"));


    }


}
