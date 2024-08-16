package pl.lderecki.tutorService.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.lderecki.tutorService.model.Subject;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubjectReadDTO {

    private Long id;

    private String name;

    public SubjectReadDTO(Subject subject) {
        this.id = subject.getId();
        this.name = subject.getName();
    }
}
