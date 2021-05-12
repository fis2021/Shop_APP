package jpm.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jpm.Services.FileSystemService;
import jpm.model.User;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;


import static jpm.Services.UserService.checkPassword;
import static jpm.Services.UserService.loadUsersFromFile;

public class LoginController {

    @FXML
    private Text loginMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;

    private static List<User> users;

    private String usernameb;
    private String passwordb;
    private static final Path USERS_PATH = FileSystemService.getPathToFile("config", "users.json");
    public void register () throws IOException {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
        Stage register_start = new Stage();
        register_start.setTitle("Shopp-App");
        register_start.setScene(new Scene(root));
        register_start.setResizable(false);
        register_start.show();
    }
    public void login () throws IOException {
        loadUsersFromFile();
        usernameb=usernameField.getText();
        passwordb=passwordField.getText();
        for (User user : users) {
            if (Objects.equals(usernameb, user.getUsername()))
            {
                if (checkPassword(user.getPassword(),passwordb,user.getUsername())){loginMessage.setText("You logged in !");}
                else loginMessage.setText("Try Aggain !");

            }
        }


    }


}
