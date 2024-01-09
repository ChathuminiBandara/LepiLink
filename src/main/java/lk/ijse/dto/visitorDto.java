package lk.ijse.dto;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter

public class visitorDto {
    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getPStatus() {
        return PStatus;
    }

    public void setPStatus(String PStatus) {
        this.PStatus = PStatus;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getBId() {
        return BId;
    }

    public void setBId(String BId) {
        this.BId = BId;
    }

    private String visitorId;
    private String Name;
    private String Status;
    private String Time;
    private String PStatus;
    private String Date;
    private String BId;


}
