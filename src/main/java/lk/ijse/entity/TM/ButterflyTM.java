package lk.ijse.entity.TM;

public class ButterflyTM implements Comparable<ButterflyTM>{

    private String bId;
    private String name;
    private String description;
    private String species;
    private String avgLifeTime;

    private String currentCount;

    public ButterflyTM(String bId, String name, String description, String species, String avgLifeTime, String currentCount) {
        this.bId = bId;
        this.name = name;
        this.description = description;
        this.species = species;
        this.avgLifeTime = avgLifeTime;
        this.currentCount = currentCount;
    }


    @Override
    public int compareTo(ButterflyTM o) {
        return bId.compareTo(o.getbId());
    }

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getAvgLifeTime() {
        return avgLifeTime;
    }

    public void setAvgLifeTime(String avgLifeTime) {
        this.avgLifeTime = avgLifeTime;
    }

    public String getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(String currentCount) {
        this.currentCount = currentCount;
    }
}
