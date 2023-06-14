package ua.lviv.iot.Taxi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.Taxi.model.Taxi;
import ua.lviv.iot.Taxi.service.TaxiService;



@Controller
public class TaxiController{
    private final TaxiService taxiService;

    @Autowired
    public TaxiController(TaxiService taxiService) {

        this.taxiService = taxiService;
    }

    @GetMapping("/taxi")
    public String getAllTaxis(Model model) {
        model.addAttribute("taxis", taxiService.findAll());
        return "taxi";
    }

    @GetMapping("/showNewTaxiForm")
    public String showNewTaxiForm(Model model) {
        Taxi taxi = new Taxi();
        model.addAttribute("taxi", taxi);
        return "create_taxi";
    }

    @GetMapping("/showUpdateTaxiForm/{id}")
    public String showUpdateTaxiForm(@PathVariable("id") Integer taxiId, Model model) {
        Taxi taxi = taxiService.getById(taxiId);
        model.addAttribute("taxi", taxi);
        return "update_taxi";
    }

    @PostMapping("/saveTaxi")
    public String saveTaxi(@ModelAttribute("taxi") Taxi taxi) {
        taxiService.saveToDatabase(taxi);
        return "redirect:/taxi";
    }

    @GetMapping("/deleteTaxi/{id}")
    public String deleteTaxi(@PathVariable("id") Integer id) {
        taxiService.deleteById(id);
        return "redirect:/taxi";
    }
}
