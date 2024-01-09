package lk.ijse.TM;

import javafx.scene.control.TextField;

public class VisitorTM implements Comparable<VisitorTM>{
    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public VisitorTM(String visitorId, String visitorName, String status, String time, String paymentStatus, String date, String reservationId) {
        this.visitorId = visitorId;
        this.visitorName = visitorName;
        this.status = status;
        this.time = time;
        this.paymentStatus = paymentStatus;
        this.date = date;
        this.reservationId = reservationId;
    }

    private  String visitorId;
    private String visitorName;
    private String status;
    private String time;
    private String paymentStatus;
    private String date;
    private String reservationId;
    public VisitorTM(){}
    @Override
    public int compareTo(VisitorTM o) {return visitorId.compareTo(o.getVisitorId());}

}
