package lk.ijse.dto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class employeeDto {


    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getTP() {
        return TP;
    }

    public void setTP(String TP) {
        this.TP = TP;
    }

    public String getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(String startedDate) {
        this.startedDate = startedDate;
    }

    public String geteSrt() {
        return eSrt;
    }

    public void seteSrt(String eSrt) {
        this.eSrt = eSrt;
    }

    private String eId;
    private String eName;
    private String TP;
    private String startedDate;
    private String eSrt;

}
