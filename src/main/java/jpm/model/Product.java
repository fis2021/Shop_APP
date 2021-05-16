package jpm.model;

public class Product {
    private String product_name;
    private String product_description;
    private String path_to_image;
    private float price;
    private String owner;

    public Product() {
    }

    public Product(String product_name,String product_description,String path_to_image,float price,String owner)
    {
        this.product_name = product_name;
        this.product_description = product_description;
        this.path_to_image = path_to_image;
        this.price = price;
        this.owner = owner;

    }

    public String getProduct_name()
    {
        return product_name;
    }

    public String getProduct_description() {
        return product_description;
    }

    public float getPrice() {
        return price;
    }

    public String getOwner() {
        return owner;
    }

    public String getPath_to_image() {
        return path_to_image;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setPath_to_image(String path_to_image) {
        this.path_to_image = path_to_image;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!product_name.equals(product.product_name)) return false;
        if (!owner.equals(product.owner)) return false;
        if (!product_description.equals(product.product_description)) return false;
        if (!path_to_image.equals(product.path_to_image)) return false;
                return (price == product.price);

    }

    public String toString() {
        return "UserDTO{" +
                "product_name='" + product_name + '\'' +
                ", owner='" + owner+ '\'' +
                ", price'" + price+ '\'' +
                ", product_description='" + product_description + '\'' +
                ", path_to_image='" + path_to_image+ '\'' +
                '}';
    }
}

