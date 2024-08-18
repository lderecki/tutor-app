package pl.lderecki.tutorService.controller;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.lderecki.tutorService.DAO.TutorDAO;
import pl.lderecki.tutorService.DTO.TutorReadDTO;
import pl.lderecki.tutorService.model.Tutor;
import pl.lderecki.tutorService.service.TutorService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tutor")
public class TutorRestController {

    private final TutorService tutorService;

    public TutorRestController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TutorReadDTO>> getAllTutors() {
        return ResponseEntity.ok(tutorService.findAll());
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TutorReadDTO>> getTutorsByCriteria(
            @RequestParam(name = "first_name", required = false) String firstName,
            @RequestParam(name = "last_name", required = false) String lastName,
            @RequestParam(name = "subject_id", required = false) Long subjectId,
            @RequestParam(name = "available_from", required = false) String availableFrom,
            @RequestParam(name = "available_to", required = false) String availableTo
    ) {

        var result = tutorService.findByCriteria(firstName, lastName, subjectId, availableFrom, availableTo);
        return ResponseEntity.ok(result);
    }
}
