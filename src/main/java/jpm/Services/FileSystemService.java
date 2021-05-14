package jpm.Services;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystemService {
    private static final String APPLICATION_FOLDER = ".jpm";
    private static final String USER_FOLDER = System.getProperty("user.home");
    private static final String PRODUCTS_FOLDER = System.getProperty("product.home");
    public static final Path APPLICATION_HOME_PATH = Paths.get(USER_FOLDER, APPLICATION_FOLDER);


    public static Path getPathToFile(String... path) {
        return APPLICATION_HOME_PATH.resolve(Paths.get(".", path));
    }
}
