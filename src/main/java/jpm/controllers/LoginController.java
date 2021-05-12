package jpm.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginController {

    public void register () throws IOException {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
        Stage register_start = new Stage();
        register_start.setTitle("Shopp-App");
        register_start.setScene(new Scene(root));
        register_start.setResizable(false);
        register_start.show();



    }
}
