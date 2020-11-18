package pl.kl.carworkshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kl.carworkshop.repository.RepairOrderRepository;

@Service
@RequiredArgsConstructor
public class RepairOrderService {

    private final RepairOrderRepository repairOrderRepository;
}
