package lk.ijse.gymsystem.entity;

public class Schedule {

    private String scheduleId;
    private String measurmentId;
    private String instructorId;
    private String customerId;
    private String description;

    public Schedule() {
    }

    public Schedule(String scheduleId, String measurmentId, String instructorId, String customerId, String description) {
        this.scheduleId = scheduleId;
        this.measurmentId = measurmentId;
        this.instructorId = instructorId;
        this.customerId = customerId;
        this.description = description;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getMeasurmentId() {
        return measurmentId;
    }

    public void setMeasurmentId(String measurmentId) {
        this.measurmentId = measurmentId;
    }

    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
