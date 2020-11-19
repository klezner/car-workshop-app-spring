package pl.kl.carworkshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kl.carworkshop.model.Car;
import pl.kl.carworkshop.model.RepairOrder;
import pl.kl.carworkshop.repository.CarRepository;
import pl.kl.carworkshop.repository.RepairOrderRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RepairOrderService {

    private final RepairOrderRepository repairOrderRepository;
    private final CarRepository carRepository;

    public Optional<Car> findCarById(Long carId) {
        return carRepository.findById(carId);
    }

    public void save(RepairOrder repairOrder) {
        repairOrderRepository.save(repairOrder);
    }

    public List<RepairOrder> findAll() {
        return repairOrderRepository.findAll();
    }

    public Optional<RepairOrder> findById(Long id) {
        return repairOrderRepository.findById(id);
    }
}
