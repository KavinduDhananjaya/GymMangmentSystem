package lk.ijse.gymsystem.dto;

public class CustomDTO {


    private String type;
    private String id;
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


    public CustomDTO() {
    }

    public CustomDTO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
