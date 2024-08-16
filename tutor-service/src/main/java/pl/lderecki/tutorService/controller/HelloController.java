package pl.lderecki.tutorService.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.lderecki.tutorService.DAO.TutorDAO;
import pl.lderecki.tutorService.DTO.TutorReadDTO;
import pl.lderecki.tutorService.model.Tutor;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class HelloController {

    private final TutorDAO tutorDAO;

    public HelloController(TutorDAO tutorDAO) {
        this.tutorDAO = tutorDAO;
    }

    @GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TutorReadDTO>> hello() {
        List<Tutor> rawResult =  tutorDAO.findAll();
        List<TutorReadDTO> result = rawResult.stream().map(TutorReadDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }
}