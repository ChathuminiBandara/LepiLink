package lk.ijse.entity;

public class order_detail {
    private String order_id;
    private String item_code;
    private String qty;
    private String unit_price;
    public order_detail(){}

    public order_detail(String order_id, String item_code, String qty, String unit_price){
        this.order_id = order_id;
        this.item_code = item_code;
        this.qty = qty;
        this.unit_price = unit_price;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getItem_code() {
        return item_code;
    }

    public void setItem_code(String item_code) {
        this.item_code = item_code;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(String unit_price) {
        this.unit_price = unit_price;
    }
}
