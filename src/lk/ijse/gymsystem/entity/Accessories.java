package lk.ijse.gymsystem.entity;

public class Accessories {

    private String type;
    private String id;
    private String brand;
    private String date;

    public Accessories() {
    }

    public Accessories(String type, String id, String brand, String date) {
        this.type = type;
        this.id = id;
        this.brand = brand;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
