package mk.finki.ukim.mk.proekt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Comparator;

@Entity
@Data
public class Game implements Comparable<Game>{

    @Id
    private String name;

    @ManyToOne
    @JoinColumn(name = "consoleId")
    @JsonIgnore
    private Console console;

    private double size;
    private String description;
    private int price;
    private boolean onStock;
    private String imageUrl;

    public Game(){}
    public Game(String name, double size, String description, int price, boolean onStock, String imageUrl, Console console){
        this.name = name;
        this.size = size;
        this.description = description;
        this.price = price;
        this.onStock = onStock;
        this.imageUrl = imageUrl;
        this.console = console;
    }


    public Game(String name, double size, String description, int price, boolean onStock, String imageUrl){
        this.name = name;
        this.size = size;
        this.description = description;
        this.price = price;
        this.onStock = onStock;
        this.imageUrl = imageUrl;
    }

    public Console getConsole() {
        return console;
    }

    public void setConsole(Console console) {
        this.console = console;
    }

    public boolean isOnStock() {
        return onStock;
    }

    public void setOnStock(boolean onStock) {
        this.onStock = onStock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {

        return String.format("On stock: %s\nName: %s\nSize: %.2fcm\nPrice: %dДЕН\nDescription: %s",
                            this.onStock ? "Yes" : "No", this.name, this.size, this.price, this.description);
    }

    @Override
    public int compareTo(Game o) {
        return Comparator.comparing(Game::getName).compare(this,o);
    }
}
