package pl.kl.carworkshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kl.carworkshop.service.RepairOrderService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order")
public class RepairOrderController {

    private final RepairOrderService repairOrderService;
}
