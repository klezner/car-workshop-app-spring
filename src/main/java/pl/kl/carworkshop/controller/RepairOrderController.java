package pl.kl.carworkshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.kl.carworkshop.model.Car;
import pl.kl.carworkshop.model.RepairOrder;
import pl.kl.carworkshop.service.RepairOrderService;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order")
public class RepairOrderController {

    private final RepairOrderService repairOrderService;

    @GetMapping("/form")
    public String getRepairOrderForm(Model model, @RequestParam("carId") Long carId) {
        model.addAttribute("addedRepairOrder", new RepairOrder());
        model.addAttribute("carId", carId);
        return "repairorder_form";
    }

    @PostMapping("")
    public String submitRepairOrder(RepairOrder repairOrder, @RequestParam("carId") Long carId) {
        Optional<Car> carOptional = repairOrderService.findCarById(carId);
        if (carOptional.isPresent()) {
            repairOrder.setCar(carOptional.get());
            repairOrderService.save(repairOrder);
        }
        return "redirect:/car";
    }

    @GetMapping("")
    public String getRepairOrders(Model model) {
        model.addAttribute("listOfRepairOrders", repairOrderService.findAll());
        return "repairorder_list";
    }

    @GetMapping("{id}")
    public String getRepairOrder(Model model, @PathVariable(name = "id") Long id) {
        Optional<RepairOrder> repairOrderOptional = repairOrderService.findById(id);
        if (repairOrderOptional.isPresent()) {
            model.addAttribute("detailedRepairOrder", repairOrderOptional.get());
            return "repairorder_details";
        }
        return "redirect:/order";
    }
}
