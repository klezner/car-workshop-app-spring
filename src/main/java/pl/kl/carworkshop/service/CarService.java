package pl.kl.carworkshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kl.carworkshop.model.Car;
import pl.kl.carworkshop.repository.CarRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public void save(Car car) {
        carRepository.save(car);
    }

    public Optional<Car> findById(Long id) {
        return carRepository.findById(id);
    }
}
