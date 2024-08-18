package pl.lderecki.tutorService.DAO;

import org.springframework.stereotype.Repository;
import pl.lderecki.tutorService.DTO.TutorSearchDTO;
import pl.lderecki.tutorService.model.AvailabilityTime;
import pl.lderecki.tutorService.model.Subject;
import pl.lderecki.tutorService.model.Tutor;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class TutorDAOImpl implements TutorDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Tutor> findAll() {
        String queryString = "select t from Tutor t join fetch t.availabilityTimeList join fetch t.subjectList";
        Query query = entityManager.createQuery(queryString);
        return query.getResultList();
    }

    @Override
    public Set<Tutor> findByCriteria(TutorSearchDTO criteria) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Tutor> query = criteriaBuilder.createQuery(Tutor.class);

        Root<Tutor> tutor = query.from(Tutor.class);

        Fetch<Tutor, AvailabilityTime> fetchAvailabilityTime = tutor.fetch("availabilityTimeList", JoinType.INNER);
        Join<Tutor, AvailabilityTime> availabilityTime = (Join<Tutor, AvailabilityTime>) fetchAvailabilityTime; //TODO temporary solution

        Fetch<Tutor, Subject> fetchSubject = tutor.fetch("subjectList", JoinType.INNER);
        Join<Tutor, Subject> subject = (Join<Tutor, Subject>) fetchSubject; //TODO temporary solution

        List<Predicate> predicates = new ArrayList<>();

        if (criteria.getFirstName() != null && !criteria.getFirstName().trim().isEmpty()) {
            predicates.add(criteriaBuilder.like(tutor.get("firstName"), "%" + criteria.getFirstName() + "%"));
        }
        if (criteria.getLastName() != null && !criteria.getLastName().trim().isEmpty()) {
            predicates.add(criteriaBuilder.like(tutor.get("lastName"), "%" + criteria.getLastName() + "%"));
        }
        if (criteria.getAvailableFrom() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(availabilityTime.get("dateTimeFrom"), criteria.getAvailableFrom()));
        }
        if (criteria.getAvailableTo() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(availabilityTime.get("dateTimeTo"), criteria.getAvailableTo()));
        }
        if (criteria.getSubjectId() != null) {
            predicates.add(criteriaBuilder.equal(subject.get("id"), criteria.getSubjectId()));
        }

        query.where(predicates.toArray(new Predicate[0]));

        return new HashSet<>(entityManager.createQuery(query).getResultList());
    }

}
