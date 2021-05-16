package jpm.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import jpm.exceptions.ProductsAlreadyExistsException;
import jpm.model.Product;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static jpm.Services.LoginService.get_user;
import static jpm.Services.ProductService.editProduct;
import static jpm.controllers.ListElementController.loadProductsFromFile;
import static jpm.controllers.MenuController.pane;


public class EditProductController implements Initializable {

    @FXML
    public TextField name;

    @FXML
    public TextField image;

    @FXML
    public TextField price;

    @FXML
    public TextArea description;

    @FXML
    public AnchorPane mainwindow;

    private static Product prod = new Product();
    public static void getProductE(Product newProduct)
    {
        prod = newProduct;
    }

    @FXML
    public void handleClose() {
        Stage stage = (Stage) mainwindow.getScene().getWindow();
        stage.close();
    }

    public void handleCloseMenu()
    {
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.close();
    }

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

    public void ConfirmButton() {

    editProduct(
                    prod,
                    name.getText(),
                    description.getText(),
                    image.getText(),
                    Float.parseFloat(price.getText()),
                    get_user());
    handleClose();
    handleCloseMenu();
    refresh();
    }
    public void CancelButton() {
        handleClose();
    }
    public void initialize(URL location, ResourceBundle resources) {

        try {
            loadProductsFromFile();
        } catch (IOException e) {
            e.printStackTrace();}

        name.setText(prod.getProduct_name());
        description.setText(prod.getProduct_description());
        image.setText(prod.getPath_to_image());
        price.setText(String.valueOf(prod.getPrice()));



    }
}

