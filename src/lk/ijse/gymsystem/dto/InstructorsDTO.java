package lk.ijse.gymsystem.dto;

public class InstructorsDTO {

    private String id;
    private String name;
    private String nic;
    private String address;
    private String email;
    private String tp;

    public InstructorsDTO() {
    }

    public InstructorsDTO(String id, String name, String nic, String address, String email, String tp) {
        this.id = id;
        this.name = name;
        this.nic = nic;
        this.address = address;
        this.email = email;
        this.tp = tp;
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

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }
}
