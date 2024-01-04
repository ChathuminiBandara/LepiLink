package lk.ijse.entity;

public class employee {
    private String eId;
    private String eName;
    private String contact;
    private String startedDate;
    private String eSrt;

    public employee(){}

    public employee(String eId, String eName, String contact, String startedDate, String eSrt){
        this.eId = eId;
        this.eName = eName;
        this.contact = contact;
        this.startedDate = startedDate;
        this.eSrt = eSrt;
    }

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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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

}
