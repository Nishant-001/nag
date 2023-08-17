package com.training.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TShirt {
    @Id
    private String id="";
    private String name = "";
    private String colour = "";
    private String gender = "";
    private String size = "";
    private float price = 0.0F;
    private float rating = 0.0F;
    private String availability = "";

    public TShirt() {
    }

    public TShirt(String id, String name, String colour, String gender, String size,
                  float price, float rating, String availability) {
        this.id = id;
        this.name = name;
        this.colour = colour;
        this.gender = gender;
        this.size = size;
        this.price = price;
        this.rating = rating;
        this.availability = availability;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    public String getAvailability() {
        return availability;
    }

    @Override
    public String toString() {
        return "TShirt{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                ", gender='" + gender + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", availability='" + availability + '\'' +
                '}';
    }
}
