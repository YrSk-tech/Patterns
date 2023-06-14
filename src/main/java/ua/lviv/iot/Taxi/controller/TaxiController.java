package ua.lviv.iot.Taxi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.Taxi.model.Taxi;
import ua.lviv.iot.Taxi.service.TaxiService;



@RestController
public class TaxiController extends AbstractController<Taxi> {
    private final TaxiService taxiService;

    @Autowired
    public TaxiController(TaxiService taxiService) {
        super(taxiService);
        this.taxiService = taxiService;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Taxi> updateUser(@PathVariable("id") Integer taxiId, @RequestBody Taxi taxi) {
        taxi.setId(taxiId);
        Taxi updatedTaxi = taxiService.update(taxiId, taxi, new Taxi());
        if (updatedTaxi != null) {
            return new ResponseEntity<>(updatedTaxi, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
