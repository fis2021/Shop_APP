package jpm.controllers;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import jpm.Services.FileSystemService;
import jpm.Services.ShippingService;
import jpm.Services.UserService;
import jpm.exceptions.NotEnoughtBalance;
import jpm.model.Product;
import jpm.model.Shipping;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static jpm.Services.LoginService.*;
import static jpm.controllers.MenuControllerBuyer.paneb;
import static jpm.controllers.ElementControllerBuyer.prod;
import static jpm.Services.ShippingService.loadShipingInfoFromFile;

public class BuyController {
    @FXML
    private TextField firstname;

    @FXML
    private TextField lastname;

    @FXML
    private TextField adress;

    @FXML
    private TextField postalcode;

    @FXML
    private AnchorPane mainwindow;


    @FXML
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

    public void packShipingInfo() throws IOException {

        loadShipingInfoFromFile();
        ShippingService.addShipingInfo(firstname.getText(),lastname.getText(),adress.getText(),postalcode.getText());
     try {
         if (get_balance() > prod.getPrice()) {
             UserService.updatebBalance(get_user(), -(prod.getPrice()));
             set_balance(-prod.getPrice());
             UserService.updatebBalance(prod.getOwner(), prod.getPrice());
         }
        else {
            throw new NotEnoughtBalance();
        }
        } catch (NotEnoughtBalance notEnoughtBalance) {
            notEnoughtBalance.printStackTrace();
        }
     handleClose();
     handleCloseMenu();
     refresh();
    }

}
