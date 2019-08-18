package lk.ijse.gymsystem.entity;

public class CustomEntity {

    private String type;
    private String accessoryid;
    private String customerid;
    private String brand;
    private int amount;
    private String date;
    private String attendanceId;
    private String arrivaltime;
    private String depatureTime;
    private String name;
    private String address;
    private String email;
    private String tel;
    private String nic;
    private String tp;
    private String scheduleId;
    private String measurmentId;
    private String instructorId;
    private String customerId;
    private String description;


    public CustomEntity() {
    }

    public CustomEntity(String type, String accessoryid, String customerid, String name) {
        this.type = type;
        this.accessoryid = accessoryid;
        this.customerid = customerid;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccessoryid() {
        return accessoryid;
    }

    public void setAccessoryid(String accessoryid) {
        this.accessoryid = accessoryid;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
