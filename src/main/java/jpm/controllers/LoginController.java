package jpm.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jpm.Services.FileSystemService;
import jpm.Services.UserService;
import jpm.model.User;
import jpm.Services.LoginService;
import org.apache.commons.io.FileUtils;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

import static jpm.Services.LoginService.*;
import static jpm.Services.UserService.checkPassword;

public class LoginController {

    @FXML
    private Text loginMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private AnchorPane mainwindow;
    @FXML
    public void handleClose() {
        Stage stage = (Stage) mainwindow.getScene().getWindow();
        stage.close();
    }


    private String usernameb;
    private String passwordb;
    private static List<User> users;
    private static final Path USERS_PATH = FileSystemService.getPathToFile("config", "users.json");

    public static void loadUsersFromFile() throws IOException {

        if (!Files.exists(USERS_PATH)) {
            FileUtils.copyURLToFile(UserService.class.getClassLoader().getResource("users.json"), USERS_PATH.toFile());
        }

        ObjectMapper objectMapper = new ObjectMapper();

        users = objectMapper.readValue(USERS_PATH.toFile(), new TypeReference<List<User>>() {
        });
    }
    public void register () throws IOException {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
        Stage register_start = new Stage();
        register_start.setTitle("Shopp-App");
        register_start.setScene(new Scene(root));
        register_start.setResizable(false);
        register_start.show();
    }

    public void login () throws IOException {
        int ok=0;
        loadUsersFromFile();
        usernameb=usernameField.getText();
        passwordb=passwordField.getText();
        for (User user : users) {
            if (Objects.equals(usernameb, user.getUsername()))
            {
                if (checkPassword(user.getPassword(),passwordb,user.getUsername())){loginMessage.setText("You logged in !");ok=1;
                    set_current_user(user);
                    if(ifseller()){
                    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("MenuSeller.fxml"));
                    Stage menu_start = new Stage();
                    menu_start.setTitle("Menu");
                    menu_start.setScene(new Scene(root));
                    menu_start.setResizable(false);
                    menu_start.show();
                    handleClose();
                    }
                    else{
                        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("MenuBuyer.fxml"));
                        Stage menu_start = new Stage();
                        menu_start.setTitle("Menu");
                        menu_start.setScene(new Scene(root));
                        menu_start.setResizable(false);
                        menu_start.show();
                        handleClose();
                    }


                }
                else {loginMessage.setText("Your Password is wrong! Try again !");ok=1;}

            }
        }
        if(ok == 0)loginMessage.setText("Account dosen't exist !");

    }


}
