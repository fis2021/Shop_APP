package jpm.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import jpm.exceptions.ProductsAlreadyExistsException;

import static jpm.Services.LoginService.get_user;
import static jpm.Services.ProductService.addProduct;

public class EditProductController {

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

    @FXML
    public void handleClose() {
        Stage stage = (Stage) mainwindow.getScene().getWindow();
        stage.close();
    }

    public void ConfirmButton() {
        try {
            addProduct(name.getText(),
                    description.getText(),
                    image.getText(),
                    Float.parseFloat(price.getText()),
                    get_user());
        } catch (ProductsAlreadyExistsException e) {
            e.printStackTrace();
        }


    }
    public void CancelButton() {
        handleClose();
    }
}

