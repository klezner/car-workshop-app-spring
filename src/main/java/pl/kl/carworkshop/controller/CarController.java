package pl.kl.carworkshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kl.carworkshop.model.Car;
import pl.kl.carworkshop.model.EngineType;
import pl.kl.carworkshop.service.CarService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    @GetMapping("")
    public String getCars(Model model) {
        model.addAttribute("listOfCars", carService.findAll());
        return "car_list";
    }

    @GetMapping("/form")
    public String getCarForm(Model model) {
        model.addAttribute("availableEngineTypes", EngineType.values());
        model.addAttribute("addedCar", new Car());
        return "car_form";
    }

    @PostMapping("")
    public String submitCar(Car car) {
        carService.save(car);
        return "redirect:/car";
    }
}
