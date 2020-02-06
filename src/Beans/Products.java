package Beans;

public class Products {

    private int id;
    private String name;
    private float price;
    private String description;
    private Brand Brand;
    private Category Category;
    private float rating;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Brand getBrand() {
        return Brand;
    }

    public void setBrand(Brand brand) {
        Brand = brand;
    }

    public Beans.Category getCategory() {
        return Category;
    }

    public void setCategory(Beans.Category category) {
        Category = category;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
