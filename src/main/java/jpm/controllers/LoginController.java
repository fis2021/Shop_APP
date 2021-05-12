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
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

import static jpm.Services.UserService.checkPassword;

public class LoginController {

    @FXML
    private Text loginMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;



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
