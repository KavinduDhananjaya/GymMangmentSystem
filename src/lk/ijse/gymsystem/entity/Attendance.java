package lk.ijse.gymsystem.entity;

public class Attendance {

    private String attendanceId;
    private String date;
    private String arrivaltime;
    private String depatureTime;


    public Attendance() {
    }

    public Attendance(String attendanceId, String date, String arrivaltime, String depatureTime) {
        this.attendanceId = attendanceId;
        this.date = date;
        this.arrivaltime = arrivaltime;
        this.depatureTime = depatureTime;
    }

    public String getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(String attendanceId) {
        this.attendanceId = attendanceId;
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
