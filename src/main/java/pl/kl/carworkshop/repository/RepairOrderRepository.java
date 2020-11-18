package pl.kl.carworkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kl.carworkshop.model.RepairOrder;

@Repository
public interface RepairOrderRepository extends JpaRepository<RepairOrder, Long> {

}
