package jpm.Services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jpm.exceptions.ProductsAlreadyExistsException;
import jpm.model.User;
import org.apache.commons.io.FileUtils;
import jpm.exceptions.CouldNotWriteUsersException;
import jpm.exceptions.ProductsAlreadyExistsException;
import jpm.model.Product;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;


public class ProductService {

    private static List<Product> Products;
    private static final Path PRODUCT_PATH = FileSystemService.getPathToFile("config","products.json");

    public static void loadProductsFromFile() throws IOException {

        if (!Files.exists(PRODUCT_PATH)) {
            FileUtils.copyURLToFile(ProductService.class.getClassLoader().getResource("products.json"), PRODUCT_PATH.toFile());
        }

        ObjectMapper objectMapper = new ObjectMapper();

        Products = objectMapper.readValue(PRODUCT_PATH.toFile(), new TypeReference<List<Product>>() {
        });
    }

    public static void addProduct (String product_name, String product_description, String path_to_image, float price, String owner) throws ProductsAlreadyExistsException {
        checkProductDoesNotAlreadyExist(product_name, owner);
        Products.add(new Product(product_name,product_description,path_to_image,price,owner));
        persistProduct();
    }
    public static void removeProduct (Product Product) throws CouldNotWriteUsersException
    {
        Products.remove(Product);
        persistProduct();
    }

    private static void checkProductDoesNotAlreadyExist(String productname,String productowner) throws ProductsAlreadyExistsException {
        for (Product product : Products) {
            if (Objects.equals(productname, product.getProduct_name()) && Objects.equals(productowner,product.getOwner()))
                throw new ProductsAlreadyExistsException(productname);
        }
    }

    public static void editProduct(Product prod,String product_name, String product_description, String path_to_image, float price, String owner) throws CouldNotWriteUsersException {
        for (Product product : Products) {
            if (Objects.equals(product,prod)){prod.setProduct_name(product_name);prod.setProduct_description(product_description);prod.setPrice(price);prod.setOwner(owner);prod.setPath_to_image(path_to_image);persistProduct();}
                throw new CouldNotWriteUsersException();

        }
    }

    private static void persistProduct() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(PRODUCT_PATH.toFile(),Products);
        } catch (IOException e) {
            throw new CouldNotWriteUsersException();
        }
    }

}