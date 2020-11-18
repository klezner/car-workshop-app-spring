package pl.kl.carworkshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kl.carworkshop.service.MechanicService;

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
}
