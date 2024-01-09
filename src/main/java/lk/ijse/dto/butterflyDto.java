package lk.ijse.dto;

import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class butterflyDto {


        public String getBId() {
                return BId;
        }

        public void setBId(String BId) {
                this.BId = BId;
        }

        public String getName() {
                return Name;
        }

        public void setName(String name) {
                Name = name;
        }

        public String getDesc() {
                return desc;
        }

        public void setDesc(String desc) {
                this.desc = desc;
        }

        public String getSpecies() {
                return Species;
        }

        public void setSpecies(String species) {
                Species = species;
        }

        public String getLifeTime() {
                return lifeTime;
        }

        public void setLifeTime(String lifeTime) {
                this.lifeTime = lifeTime;
        }

        public String getCount() {
                return count;
        }

        public void setCount(String count) {
                this.count = count;
        }

        private String BId;
        private String Name;
        private String desc;
        private String Species;
        private String lifeTime;
        private String count;


}
