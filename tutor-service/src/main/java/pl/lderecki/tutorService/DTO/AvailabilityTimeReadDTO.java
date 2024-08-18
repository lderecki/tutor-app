package pl.lderecki.tutorService.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.lderecki.tutorService.model.AvailabilityTime;

import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AvailabilityTimeReadDTO {

    private Long id;

    private String dateTimeFrom;

    private String dateTimeTo;

    private Long tutorId;

    public AvailabilityTimeReadDTO(AvailabilityTime availabilityTime, DateTimeFormatter formatter) {
        this.id = availabilityTime.getId();
        this.dateTimeFrom = formatter.format(availabilityTime.getDateTimeFrom());
        this.dateTimeTo = formatter.format(availabilityTime.getDateTimeTo());
        this.tutorId = availabilityTime.getTutor().getId();
    }


}
