package pl.lderecki.tutorService.service;

import org.springframework.stereotype.Service;
import pl.lderecki.tutorService.DAO.TutorDAO;
import pl.lderecki.tutorService.DTO.TutorReadDTO;
import pl.lderecki.tutorService.DTO.TutorSearchDTO;
import pl.lderecki.tutorService.components.DataFormatters;
import pl.lderecki.tutorService.model.Tutor;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TutorServiceImpl implements TutorService{

    private final TutorDAO tutorDAO;
    private final DataFormatters dataFormatters;

    public TutorServiceImpl(TutorDAO tutorDAO, DataFormatters dataFormatters) {
        this.tutorDAO = tutorDAO;
        this.dataFormatters = dataFormatters;
    }


    @Override
    public List<TutorReadDTO> findAll() {
        List<Tutor> rawResult =  tutorDAO.findAll();
        return rawResult.stream().map(t -> new TutorReadDTO(t, dataFormatters.getDateTimeFormatter())).toList();
    }

    @Override
    public TutorReadDTO findById(long id) {
        return null;
    }

    @Override
    public List<TutorReadDTO> findByCriteria(String firstName,
                                             String lastName,
                                             Long subjectId,
                                             String availableFrom,
                                             String availableTo) {

        var criteria = new TutorSearchDTO(firstName, lastName, subjectId,
                availableFrom != null ? LocalDateTime.parse(availableFrom, dataFormatters.getDateTimeFormatter()) : null,
                availableTo != null ? LocalDateTime.parse(availableTo, dataFormatters.getDateTimeFormatter()) : null);

        var rawResult = tutorDAO.findByCriteria(criteria);
        return rawResult.stream().map(t -> new TutorReadDTO(t, dataFormatters.getDateTimeFormatter())).toList();
    }

    @Override
    public void deleteById(long id) {

    }
}
