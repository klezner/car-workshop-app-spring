package pl.kl.carworkshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kl.carworkshop.model.Mechanic;
import pl.kl.carworkshop.repository.MechanicRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MechanicService {

    private final MechanicRepository mechanicRepository;

    public List<Mechanic> findAll() {
        return mechanicRepository.findAll();
    }

    public void save(Mechanic mechanic) {
        mechanicRepository.save(mechanic);
    }

    public Optional<Mechanic> findById(Long id) {
        return mechanicRepository.findById(id);
    }

    public void deleteById(Long id) {
        mechanicRepository.deleteById(id);
    }
}
