package lk.ijse.entity.TM;

public class SupTM implements Comparable<SupTM>{
    public SupTM(){}
    @Override
    public int compareTo(SupTM o) {
        return 0;
    }
    public SupTM(String id, String cN, String qtys, String tp) {
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierCompanyName() {
        return supplierCompanyName;
    }

    public void setSupplierCompanyName(String supplierCompanyName) {
        this.supplierCompanyName = supplierCompanyName;
    }

    public String getDateSupplied() {
        return dateSupplied;
    }

    public void setDateSupplied(String dateSupplied) {
        this.dateSupplied = dateSupplied;
    }

    public String getQtySupplied() {
        return qtySupplied;
    }

    public void setQtySupplied(String qtySupplied) {
        this.qtySupplied = qtySupplied;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    private String supplierId;
    private String supplierName;
    private String supplierCompanyName;
    private String dateSupplied;
    private String qtySupplied;
    private String pId;

}

