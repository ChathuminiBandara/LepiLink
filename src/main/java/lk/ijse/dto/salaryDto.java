package lk.ijse.dto;
import lombok.*;


@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor


public class salaryDto {
    private String sId;
    private String Status;
    private String Amount;
    private String EmpId;

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


}
