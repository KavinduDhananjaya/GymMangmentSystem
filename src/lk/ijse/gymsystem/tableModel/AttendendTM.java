package lk.ijse.gymsystem.tableModel;

public class AttendendTM {

    private String date;
    private String arrivaltime;
    private String depatureTime;


    public AttendendTM() {
    }

    public AttendendTM(String date, String arrivaltime, String depatureTime) {
        this.date = date;
        this.arrivaltime = arrivaltime;
        this.depatureTime = depatureTime;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getArrivaltime() {
        return arrivaltime;
    }

    public void setArrivaltime(String arrivaltime) {
        this.arrivaltime = arrivaltime;
    }

    public String getDepatureTime() {
        return depatureTime;
    }

    public void setDepatureTime(String depatureTime) {
        this.depatureTime = depatureTime;
    }
}
