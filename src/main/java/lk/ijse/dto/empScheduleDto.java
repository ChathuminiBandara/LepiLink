package lk.ijse.dto;
import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class empScheduleDto {
    private String scheduleId;
    private String supervisor;
    private String scheduleLocation;
    private String date;
    private String empId;
    private String description;
    private String scheduleNote;

}
