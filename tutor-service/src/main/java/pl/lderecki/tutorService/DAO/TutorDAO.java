package pl.lderecki.tutorService.DAO;

import pl.lderecki.tutorService.DTO.TutorSearchDTO;
import pl.lderecki.tutorService.model.Tutor;

import java.util.List;
import java.util.Set;

public interface TutorDAO {

    List<Tutor> findAll();

    Set<Tutor> findByCriteria(TutorSearchDTO criteria);
}
