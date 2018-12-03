import javafx.scene.image.Image;



public class Product {
    private String make, model, variant;
    private Double price;
    private Integer year, quantity;
    private Image image;
    public Product( String make, String model, String variant, Double price, Integer year, Integer quantity, Image image) {
        setMake(make);
        setModel(model);
        setVariant(variant);
        setPrice(price);
        setYear(year);
        setQuantity(quantity);
        setImage(image);
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        if(make.isEmpty())
            throw new IllegalArgumentException("Make must be filled ");
        else
            this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if(model.isEmpty())
            throw new IllegalArgumentException("Model must be filled in");
        else
            this.model = model;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
      if(variant.isEmpty())
          throw new IllegalArgumentException("Variant must be filled in");
      else
        this.variant = variant;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
      if(price < 0 )
          throw new IllegalArgumentException("Price must be positive");
      else
        this.price = price;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }



    public void sellProduct(Integer amount){
        if(quantity > 0)
           this.quantity -= amount;
        else
            throw new IllegalArgumentException("Cannot sell "+ this.model +" with no inventory");

    }

    public String toString(){
        return String.format("%s, %s, %s, %s, %s, %s",make,model,variant, year, quantity,price);
    }
}
