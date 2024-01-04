package lk.ijse.entity;

public class supplier {
    private String supplierId;
    private String supplierNAme;
    private String supplierCompanyName;
    private String dateSupplied;
    private String qtysupplied;
    private String pId;

    public supplier(){}

    public supplier(String supplierId, String supplierNAme, String supplierCompanyName, String dateSupplied, String qtysupplied, String pId){
        this.supplierId = supplierId;
        this.supplierNAme = supplierNAme;
        this.supplierCompanyName = supplierCompanyName;
        this.dateSupplied = dateSupplied;
        this.qtysupplied = qtysupplied;
        this.pId = pId;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierNAme() {
        return supplierNAme;
    }

    public void setSupplierNAme(String supplierNAme) {
        this.supplierNAme = supplierNAme;
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

    public String getQtysupplied() {
        return qtysupplied;
    }

    public void setQtysupplied(String qtysupplied) {
        this.qtysupplied = qtysupplied;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }
}
