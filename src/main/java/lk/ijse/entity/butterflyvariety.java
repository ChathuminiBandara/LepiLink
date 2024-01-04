package lk.ijse.entity;

public class butterflyvariety {
    private String bId;
    private String name;
    private String desc;
    private String species;
    private String avgLifetime;
    private String currentCount;

    public butterflyvariety(String bId, String name, String desc, String species, String avgLifetime, String currentCount){
        this.bId = bId;
        this.name = name;
        this.desc = desc;
        this.species = species;
        this.avgLifetime = avgLifetime;
        this.currentCount = currentCount;
    }
    public butterflyvariety(){}

    public String getbId() {return bId;}

    public void setbId(String bId) {this.bId = bId;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getDesc() {return desc;}

    public void setDesc(String desc) {this.desc = desc;}

    public String getSpecies() {return species;}

    public void setSpecies(String species) {this.species = species;}

    public String getAvgLifetime() {return avgLifetime;}

    public void setAvgLifetime(String avgLifetime) {this.avgLifetime = avgLifetime;}

    public String getCurrentCount() {return currentCount;}

    public void setCurrentCount(String currentCount) {this.currentCount = currentCount;}


}
