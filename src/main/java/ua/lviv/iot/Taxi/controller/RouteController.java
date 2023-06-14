package ua.lviv.iot.Taxi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.Taxi.model.Route;
import ua.lviv.iot.Taxi.service.RouteService;



@RestController
@RequestMapping("/route")
public class RouteController extends AbstractController<Route> {
    private final RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService) {
        super(routeService);
        this.routeService = routeService;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Route> updateRestaurant(@PathVariable("id") Integer routeId,
                                                       @RequestBody Route route) {
        route.setId(routeId);
        Route updatedRoute = routeService.update(routeId, route, new Route());
        if (updatedRoute != null) {
            return new ResponseEntity<>(updatedRoute, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
