package lk.ijse.TM;

public class SalaryTM implements Comparable<SalaryTM>{
    private String sId;

    private String Status;

    public SalaryTM(String id,String Status,String Amount,String eId) {}

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getEmpId() {
        return EmpId;
    }

    public void setEmpId(String empId) {
        EmpId = empId;
    }
    private String Amount;
    private String EmpId;
    public SalaryTM() {}

    @Override
    public int compareTo(SalaryTM o) {return sId.compareTo(o.getsId());}
}
