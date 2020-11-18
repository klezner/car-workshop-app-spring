package pl.kl.carworkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kl.carworkshop.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
