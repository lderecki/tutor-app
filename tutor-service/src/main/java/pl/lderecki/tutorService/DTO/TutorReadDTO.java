package pl.lderecki.tutorService.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.lderecki.tutorService.model.Tutor;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TutorReadDTO {

    public TutorReadDTO(Tutor tutor, DateTimeFormatter formatter) {
        this.id = tutor.getId();
        this.firstName = tutor.getFirstName();
        this.lastName = tutor.getLastName();
        this.userName = tutor.getUserName();
        this.password = tutor.getPassword();
        this.availabilityTimeList = tutor.getAvailabilityTimeList()
                .stream()
                .map(a -> new AvailabilityTimeReadDTO(a, formatter))
                .collect(Collectors.toList());

        this.subjectList = tutor.getSubjectList()
                .stream()
                .map(SubjectReadDTO::new)
                .collect(Collectors.toList());
    }

    private Long id;

    private String firstName;

    private String lastName;

    private String userName;

    private String password;

    private String email;

    private List<AvailabilityTimeReadDTO> availabilityTimeList = new ArrayList<>();

    private List<SubjectReadDTO> subjectList = new ArrayList<>();
}
