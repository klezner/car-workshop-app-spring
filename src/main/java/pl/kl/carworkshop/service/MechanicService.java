package pl.kl.carworkshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kl.carworkshop.model.Mechanic;
import pl.kl.carworkshop.repository.MechanicRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MechanicService {

    private final MechanicRepository mechanicRepository;

    public List<Mechanic> findAll() {
        return mechanicRepository.findAll();
    }
}
