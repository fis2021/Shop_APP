package jpm.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class ListElementController implements Initializable {
    @FXML
    private VBox itemHolder;
    @FXML
    private ScrollPane scrollPane;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       //build nodes
        Node[] nodes = new Node[10];
        for(int i=0;i < nodes.length;i++)
            try {
                final int j = i;
                nodes[i] = FXMLLoader.load(getClass().getClassLoader().getResource("list_element.fxml"));
                //mouseover effect


               nodes[i].setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        nodes[j].setStyle("-fx-background-color : #B3B1B1");
                    }
                });

                nodes[i].setOnMouseExited(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        nodes[j].setStyle("-fx-background-color : #D9D8D8");
                    }
                });


                // add test items
                itemHolder.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

