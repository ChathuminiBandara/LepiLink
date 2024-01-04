package lk.ijse.entity;

public class salary {
    private String sId;
    private String status;
    private String amount;
    private String empId;

    public salary(String sId, String status, String amount, String empId){
        this.sId = sId;
        this.status = status;
        this.amount = amount;
        this.empId = empId;
    }

    public salary(){}

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }
}
