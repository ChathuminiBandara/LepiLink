package lk.ijse.entity;

public class schedule {
    private String scheduleId;
    private String supervisor;
    private String scheduleNote;
    private String scheduleLocation;
    private String description;
    private String date;
    private String empId;

    public schedule(){}

    public schedule(String scheduleId, String supervisor, String scheduleNote, String scheduleLocation, String description, String date, String empId){
        this.scheduleId = scheduleId;
        this.supervisor = supervisor;
        this.scheduleNote = scheduleNote;
        this.scheduleLocation = scheduleLocation;
        this.description = description;
        this.date = date;
        this.empId = empId;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getScheduleNote() {
        return scheduleNote;
    }

    public void setScheduleNote(String scheduleNote) {
        this.scheduleNote = scheduleNote;
    }

    public String getScheduleLocation() {
        return scheduleLocation;
    }

    public void setScheduleLocation(String scheduleLocation) {
        this.scheduleLocation = scheduleLocation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

}
