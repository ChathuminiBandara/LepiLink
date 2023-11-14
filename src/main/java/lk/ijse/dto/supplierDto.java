package lk.ijse.dto;

public class supplierDto {

    private String supplierId;
    private String supplierName;
    private String supplierCompanyName;
    private String dateSupplied;
    private String qtySupplied;
    private String pId;

    public static class VisitorDto {
        public VisitorDto(String visitorId, String name, String status, String time, String pStatus, String date) {
        }
    }
}
