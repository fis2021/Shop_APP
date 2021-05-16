package jpm.controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.awt.*;
import java.io.IOException;

import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.Scene;




import static jpm.controllers.MenuController.pane;
import jpm.exceptions.ProductsAlreadyExistsException;
import jpm.model.User;
import static jpm.Services.ProductService.addProduct;
import static jpm.Services.LoginService.get_user;
public class AddProductController {

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
        try {
            addProduct(name.getText(),
                    description.getText(),
                    image.getText(),
                    Float.parseFloat(price.getText()),
                    get_user());
        } catch (ProductsAlreadyExistsException e) {
            e.printStackTrace();
        }
        handleClose();
        handleCloseMenu();
        refresh();
    }
    public void CancelButton() {
        handleClose();
    }
}

