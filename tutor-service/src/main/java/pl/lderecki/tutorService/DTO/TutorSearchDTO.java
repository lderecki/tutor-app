package pl.lderecki.tutorService.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TutorSearchDTO {

    private String firstName;

    private String lastName;

    private Long subjectId;

    private LocalDateTime availableFrom;

    private LocalDateTime availableTo;
}
