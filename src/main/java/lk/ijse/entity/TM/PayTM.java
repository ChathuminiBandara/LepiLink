package lk.ijse.entity.TM;

public class PayTM implements Comparable<PayTM>{
    public PayTM() {
    }

    public PayTM(String id, String vn, String ps, String vc) {

    }
    private String Id;
    private String Vn;
    private String Ps;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getVn() {
        return Vn;
    }

    public void setVn(String vn) {
        Vn = vn;
    }

    public String getPs() {
        return Ps;
    }

    public void setPs(String ps) {
        Ps = ps;
    }

    public String getVc() {
        return Vc;
    }

    public void setVc(String vc) {
        Vc = vc;
    }

    private String Vc;

    @Override
    public int compareTo(PayTM o) {
        return Id.compareTo(o.getId());
    }
}
