package lk.ijse.entity;

public class bedetails {
    private String dateEntered;
    private String status;
    private String empId;
    private String bId;
    public bedetails(){}
    public bedetails(String dateEntered, String status, String empId, String bId){
        this.dateEntered = dateEntered;
        this.status = status;
        this.empId = empId;
        this.bId = bId;
    }

    public String getDateEntered() {
        return dateEntered;
    }

    public void setDateEntered(String dateEntered) {
        this.dateEntered = dateEntered;
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

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }
}
