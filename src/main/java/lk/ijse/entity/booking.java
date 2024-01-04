package lk.ijse.entity;

public class booking {
    private String reservationId;
    private String visitorName;
    private String visitDate;
    private String eventName;
    private String paymentStatus;
    private String numberOfAttendence;

    public booking(){}

    public booking(String reservationId, String visitorName, String visitDate, String eventName, String paymentStatus, String numberOfAttendence){
        this.reservationId = reservationId;
        this.visitorName = visitorName;
        this.visitDate = visitDate;
        this.eventName = eventName;
        this.paymentStatus = paymentStatus;
        this.numberOfAttendence = numberOfAttendence;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getNumberOfAttendence() {
        return numberOfAttendence;
    }

    public void setNumberOfAttendence(String numberOfAttendence) {
        this.numberOfAttendence = numberOfAttendence;
    }

}
