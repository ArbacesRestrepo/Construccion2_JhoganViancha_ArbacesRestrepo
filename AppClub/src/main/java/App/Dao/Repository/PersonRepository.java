package App.Dao.Repository;

/**
 * @author Arbaces Restrepo, Yhogan Viancha, Kevin Parra
 */

import App.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
    public boolean existsByDocument( long document );

    public Person findById( long id );
    public Person findByDocument( long document );
}
