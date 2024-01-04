package lk.ijse.entity;

public class goods {
    private String pId;
    private String pName;
    private String description;
    private String dateSupplied;
    private String pAvailability;
    private String qtyOnHand;

    public goods(){}

    public goods(String pId , String pName, String description, String dateSupplied , String pAvailability, String qtyOnHand){
        this.pId = pId;
        this.pName = pName;
        this.description = description;
        this.dateSupplied = dateSupplied;
        this.pAvailability = pAvailability;
        this.qtyOnHand = qtyOnHand;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateSupplied() {
        return dateSupplied;
    }

    public void setDateSupplied(String dateSupplied) {
        this.dateSupplied = dateSupplied;
    }

    public String getpAvailability() {
        return pAvailability;
    }

    public void setpAvailability(String pAvailability) {
        this.pAvailability = pAvailability;
    }

    public String getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(String qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }
}
