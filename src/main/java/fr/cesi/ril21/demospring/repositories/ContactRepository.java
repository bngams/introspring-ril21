package fr.cesi.ril21.demospring.repositories;

import fr.cesi.ril21.demospring.entities.Contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// @Component
@Repository
public interface ContactRepository
        extends CrudRepository<Contact, Long> {

    // query methods
    List<Contact> findByLastname(String name);
    Contact findFirstByLastname(String name);

    // JPQL or Native Query
    @Query(value="SELECT * FROM contacts " +
            "WHERE firstname LIKE %:word%" +
            "OR lastname LIKE %:word%", nativeQuery = true)
    List<Contact> search(String word);
}
