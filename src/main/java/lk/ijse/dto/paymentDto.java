package lk.ijse.dto;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class paymentDto {
    private String paymentId;
    private String visitorName;

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getVisitorContactNum() {
        return visitorContactNum;
    }

    public void setVisitorContactNum(String visitorContactNum) {
        this.visitorContactNum = visitorContactNum;
    }

    private String paymentStatus;
    private String visitorContactNum;


}
