package ua.lviv.iot.Taxi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.Taxi.model.Route;
import ua.lviv.iot.Taxi.model.Taxi;
import ua.lviv.iot.Taxi.model.User;
import ua.lviv.iot.Taxi.repository.FileRepository;



import java.util.List;

@Service
public class DBLoaderService {
    @Autowired
    FileRepository repository;

    TaxiService taxiService;

    UserService userService;

    RouteService routeService;

    @Autowired
    public DBLoaderService(TaxiService taxiService, UserService userService,
                           RouteService routeService) {
        this.taxiService = taxiService;
        this.userService = userService;
        this.routeService = routeService;
    }

    public void dumpCsvToDB(String filepath) {
        List<String[]> data = repository.readAll(filepath);
        data.forEach(entry -> {
            switch (entry[0]) {
                case "Taxi":
                    Taxi taxi = taxiService.mapCsvToObject(entry);
                    taxiService.saveToDatabase(taxi);
                    break;
                case "USER": {
                    User user = userService.mapCsvToObject(entry);
                    userService.saveToDatabase(user);
                    break;
                }
                case "Route": {
                    Route route = routeService.mapCsvToObject(entry);
                    routeService.saveToDatabase(route);
                    break;
                }
            }
        });
    }
}
