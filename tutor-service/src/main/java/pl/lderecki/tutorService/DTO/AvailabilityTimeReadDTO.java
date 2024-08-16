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

    public AvailabilityTimeReadDTO(AvailabilityTime availabilityTime) {
        this.id = availabilityTime.getId();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        this.dateTimeFrom = formatter.format(availabilityTime.getDateTimeFrom());
        this.dateTimeTo = formatter.format(availabilityTime.getDateTimeTo());
        this.tutorId = availabilityTime.getTutor().getId();

    }

    private Long id;

    private String dateTimeFrom;

    private String dateTimeTo;

    private Long tutorId;
}
