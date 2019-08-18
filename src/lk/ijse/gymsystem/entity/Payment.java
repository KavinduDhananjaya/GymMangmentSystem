package lk.ijse.gymsystem.entity;

public class Payment {


    private String pid;
    private String cid;
    private String date;
    private double amount;
    private  String discroption;


    public Payment() {
    }

    public Payment(String pid, String cid, String date, double amount, String discroption) {
        this.pid = pid;
        this.cid = cid;
        this.date = date;
        this.amount = amount;
        this.discroption = discroption;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDiscroption() {
        return discroption;
    }

    public void setDiscroption(String discroption) {
        this.discroption = discroption;
    }
}
