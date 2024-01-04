package lk.ijse.entity;

public class payment {
    private String paymentId;
    private String  visitorName;
    private String paymentStatus;
    private String visitorContactNum;
    private String reservationId;
    public payment(){}

    public payment(String paymentId, String visitorName, String paymentStatus, String visitorContactNum, String reservationId ){
        this.paymentId = paymentId;
        this. visitorName = visitorName;
        this.paymentStatus = paymentStatus;
        this.visitorContactNum = visitorContactNum;
        this.reservationId = reservationId;
    }

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

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }
}
