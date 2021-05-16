package jpm.Services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;


import jpm.model.Shipping;

import static java.util.Objects.*;


public class ShippingService {

    private static List<Shipping> info;
    private static final Path SHIPING_INFO_PATH = FileSystemService.getPathToFile("config","info_shipping.json");

    public static void loadShipingInfoFromFile() throws IOException {

        if (!Files.exists(SHIPING_INFO_PATH)) {
            FileUtils.copyURLToFile(requireNonNull(ShippingService.class.getClassLoader().getResource("info_shipping.json")), SHIPING_INFO_PATH.toFile());
        }

        ObjectMapper objectMapper = new ObjectMapper();

        info = objectMapper.readValue(SHIPING_INFO_PATH.toFile(),new TypeReference<List<Shipping>>() {});
    }

    public static void addShipingInfo (String fname, String lname, String adress, String pc) {
        info.add(new Shipping(fname,lname,adress,pc));
        persistShipping_info();
    }
    public static void removeShipingInfo (Shipping shipping_)
    {
        info.remove(shipping_);
        persistShipping_info();
    }

    public static void editShipingInfo(Shipping infot, String fname, String lname, String adress, String pc)  {
        info.remove(infot);
        info.add(new Shipping(fname, lname,adress,pc));
        persistShipping_info();
    }

    private static void persistShipping_info() {

            ObjectMapper objectMapperinfo = new ObjectMapper();
        try {
            objectMapperinfo.writerWithDefaultPrettyPrinter().writeValue(SHIPING_INFO_PATH.toFile(),info);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}