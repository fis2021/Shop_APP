package jpm.exceptions;

public class ProductsAlreadyExistsException extends Exception{

    private String productname;

    public ProductsAlreadyExistsException(String productname) {
        super(String.format("The product %s already exists on your list!", productname));
        this.productname = productname;
    }


}
