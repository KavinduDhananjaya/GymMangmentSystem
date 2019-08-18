package lk.ijse.gymsystem.entity;

public class Measurement {

    private String id;
    private String  date;
    private int height;
    private int weight;
    private int chest;
    private int waist;
    private int arm;
    private int calf;

    public Measurement() {
    }


    public Measurement(String id, String date, int height, int weight, int chest, int waist, int arm, int calf) {
        this.id = id;
        this.date = date;
        this.height = height;
        this.weight = weight;
        this.chest = chest;
        this.waist = waist;
        this.arm = arm;
        this.calf = calf;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getChest() {
        return chest;
    }

    public void setChest(int chest) {
        this.chest = chest;
    }

    public int getWaist() {
        return waist;
    }

    public void setWaist(int waist) {
        this.waist = waist;
    }

    public int getArm() {
        return arm;
    }

    public void setArm(int arm) {
        this.arm = arm;
    }

    public int getCalf() {
        return calf;
    }

    public void setCalf(int calf) {
        this.calf = calf;
    }
}
