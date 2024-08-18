package pl.lderecki.tutorService.service;


import pl.lderecki.tutorService.DTO.TutorReadDTO;
import pl.lderecki.tutorService.DTO.TutorSearchDTO;

import java.util.List;

public interface TutorService {

    List<TutorReadDTO> findAll();

    TutorReadDTO findById(long id);

    List<TutorReadDTO> findByCriteria(String firstName,
                                      String lastName,
                                      Long subjectId,
                                      String availableFrom,
                                      String availableTo);

    void deleteById(long id);
}
