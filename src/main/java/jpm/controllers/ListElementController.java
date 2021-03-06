package jpm.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.*;


import jpm.Services.FileSystemService;
import jpm.Services.ProductService;
import jpm.Services.ShippingService;
import jpm.model.Product;
import jpm.model.Shipping;
import jpm.model.User;
import org.apache.commons.io.FileUtils;

import static jpm.Services.LoginService.get_role;
import static jpm.Services.LoginService.get_user;

import static jpm.controllers.ElementController.getProduct;
import static jpm.controllers.EditProductController.getProductE;
import static jpm.controllers.ElementControllerBuyer.getProductB;


public class ListElementController implements Initializable {
    @FXML
    private VBox itemHolder;
    @FXML
    private ScrollPane scrollPane;

    private User user;


    private static List<Product> products;
    private static final Path PRODUCT_PATH = FileSystemService.getPathToFile("config","products.json");

    public static void loadProductsFromFile() throws IOException {

        if (!Files.exists(PRODUCT_PATH)) {
            FileUtils.copyURLToFile(ProductService.class.getClassLoader().getResource("products.json"), PRODUCT_PATH.toFile());
        }

        ObjectMapper objectMapper = new ObjectMapper();

        products = objectMapper.readValue(PRODUCT_PATH.toFile(), new TypeReference<List<Product>>() {
        });
    }

    private static List<Shipping> info;
    private static final Path SHIPING_INFO_PATH = FileSystemService.getPathToFile("config", "info_shipping.json");

    public static void loadShipingInfoFromFile() throws IOException {

        if (!Files.exists(SHIPING_INFO_PATH)) {
            FileUtils.copyURLToFile(ShippingService.class.getClassLoader().getResource("info_shipping.json"), SHIPING_INFO_PATH.toFile());
        }

        ObjectMapper objectMapper = new ObjectMapper();

        info = objectMapper.readValue(SHIPING_INFO_PATH.toFile(), new TypeReference<List<Shipping>>() {
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            loadProductsFromFile();
            loadShipingInfoFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int i = 0;
            for (Product product : products) {
                if(get_role().equals("Seller")){
                if(product.getOwner().equals(get_user())){
                try {
                    final int j = i;
                    Node[] nodes = new Node[20];

                        getProduct(product);
                        getProductE(product);

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

                    itemHolder.getChildren().add(nodes[i]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                i++;}}
                else  try {
                    final int j = i;
                    Node[] nodes = new Node[20];
                    getProductB(product);
                    nodes[i] = FXMLLoader.load(getClass().getClassLoader().getResource("list_element_buyer.fxml"));

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

                    itemHolder.getChildren().add(nodes[i]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }}