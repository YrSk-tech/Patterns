package ua.lviv.iot.Taxi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.Taxi.model.Route;
import ua.lviv.iot.Taxi.model.Taxi;
import ua.lviv.iot.Taxi.model.User;
import ua.lviv.iot.Taxi.repository.RouteRepository;

@Service
public class RouteService extends AbstractService<Route>{
    private final UserService userService;
    private final TaxiService taxiService;

    @Autowired
    public RouteService(RouteRepository routeRepository, UserService userService,
                        TaxiService taxiService) {
        super(routeRepository);
        this.userService = userService;
        this.taxiService = taxiService;
    }

    @Override
    public Route mapCsvToObject(String[] objectCsv) {
        String pickUp = objectCsv[1];
        String destination = objectCsv[2];
        Taxi taxi = taxiService.getById(Integer.parseInt(objectCsv[3]));
        User user = userService.getById(Integer.parseInt(objectCsv[4]));

        return new Route(pickUp, destination,  user, taxi);
    }
}
