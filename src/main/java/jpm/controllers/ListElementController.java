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
import java.nio.file.Path;
import java.util.List;
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
import jpm.Services.FileSystemService;
import jpm.Services.ProductService;
import jpm.model.Product;
import jpm.Services.ProductService.*;
import jpm.model.User;


public class ListElementController implements Initializable {
    @FXML
    private VBox itemHolder;
    @FXML
    private ScrollPane scrollPane;

    private static List<Product> products;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //build nodes
        try {
            ProductService.loadProductsFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (products==null){}
        else {
            int i = 0;
            for (Product product : products) {
                try {
                    final int j = i;
                    Node[] nodes = new Node[20];
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
                    /*Node[] nodes = new Node[10];
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
            }*///Test

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }}}