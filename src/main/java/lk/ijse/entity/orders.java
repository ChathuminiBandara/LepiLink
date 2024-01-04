package lk.ijse.entity;

public class orders {
    private String order_id;
    private String cus_id;
    private String date;
    public orders(){}

    public orders(String order_id, String cus_id, String date){
        this.order_id = order_id;
        this.cus_id = cus_id;
        this.date = date;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getCus_id() {
        return cus_id;
    }

    public void setCus_id(String cus_id) {
        this.cus_id = cus_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
