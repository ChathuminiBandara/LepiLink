package lk.ijse.entity;

public class area {
    private String areaId;
    private String areaName;
    private String areaType;
    private String bVaraietyCount;

    public area(){}

    public area(String areaId, String areaName, String areaType, String bVaraietyCount){
        this.areaId = areaId;
        this.areaType = areaType;
        this.areaName = areaName;
        this.bVaraietyCount = bVaraietyCount;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaType() {
        return areaType;
    }

    public void setAreaType(String areaType) {
        this.areaType = areaType;
    }

    public String getbVaraietyCount() {
        return bVaraietyCount;
    }

    public void setbVaraietyCount(String bVaraietyCount) {
        this.bVaraietyCount = bVaraietyCount;
    }

}
