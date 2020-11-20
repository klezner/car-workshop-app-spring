package pl.kl.carworkshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kl.carworkshop.model.EmploymentLevel;
import pl.kl.carworkshop.model.Mechanic;
import pl.kl.carworkshop.service.MechanicService;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mechanic")
public class MechanicController {

    private final MechanicService mechanicService;

    @GetMapping
    public String getMechanics(Model model) {
        model.addAttribute("listOfMechanics", mechanicService.findAll());
        return "mechanic_list";
    }

    @GetMapping("/form")
    public String getMechanicForm(Model model) {
        model.addAttribute("availableEmploymentLevels", EmploymentLevel.values());
        model.addAttribute("addedMechanic", new Mechanic());
        return "mechanic_form";
    }

    @PostMapping
    public String submitMechanic(Mechanic mechanic) {
        mechanicService.save(mechanic);
        return "redirect:/mechanic";
    }

    @GetMapping("{id}")
    public String getMechanic(Model model, @PathVariable(name = "id") Long id) {
        Optional<Mechanic> mechanicOptional = mechanicService.findById(id);
        if (mechanicOptional.isPresent()) {
            model.addAttribute("detailedMechanic", mechanicOptional.get());
            return "mechanic_details";
        }
        return "redirect:/mechanic";
    }

    @GetMapping("/delete/{id}")
    public String deleteMechanic(@PathVariable(name = "id") Long id) {
        mechanicService.deleteById(id);
        return "redirect:/mechanic";
    }

    @GetMapping("/edit/{id}")
    public String editMechanic(Model model, @PathVariable(name = "id") Long id) {
        Optional<Mechanic> mechanicOptional = mechanicService.findById(id);
        if (mechanicOptional.isPresent()) {
            model.addAttribute("addedMechanic", mechanicOptional.get());
            model.addAttribute("availableEmploymentLevels", EmploymentLevel.values());
            return "mechanic_form";
        }
        return "redirect:/mechanic";
    }
}
