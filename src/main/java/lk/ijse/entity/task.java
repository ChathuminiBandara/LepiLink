package lk.ijse.entity;

public class task {
    private String taskId;
    private String description;
    private String creationDate;
    private String completionDate;
    private String notes;
    private String status;
    private String empId;

    public task(){}

    public task(String taskId , String description, String creationDate, String completionDate, String notes, String status, String empId){
        this.taskId = taskId;
        this.description = description;
        this.creationDate = creationDate;
        this.completionDate = completionDate;
        this.notes = notes;
        this.status = status;
        this.empId = empId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }
}
