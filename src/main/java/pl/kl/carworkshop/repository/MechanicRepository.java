package pl.kl.carworkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kl.carworkshop.model.Mechanic;

@Repository
public interface MechanicRepository extends JpaRepository<Mechanic, Long> {

}
