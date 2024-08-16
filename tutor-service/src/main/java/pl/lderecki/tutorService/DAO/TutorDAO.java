package pl.lderecki.tutorService.DAO;

import org.springframework.stereotype.Repository;
import pl.lderecki.tutorService.model.Tutor;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class TutorDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Tutor> findAll() {
        String queryString = "select t from Tutor t";  // join t.availabilityTimeList join t.subjectList
        Query query = entityManager.createQuery(queryString);

        return query.getResultList();
    }
}
