package ua.lviv.iot.Taxi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.Taxi.model.Taxi;
import ua.lviv.iot.Taxi.model.User;
import ua.lviv.iot.Taxi.repository.UserRepository;


import java.time.LocalDate;

@Service
public class UserService extends AbstractService<User> {

    private final TaxiService TaxiService;

    @Autowired
    public UserService(UserRepository userRepository, TaxiService TaxiService) {
        super(userRepository);
        this.TaxiService = TaxiService;
    }

    @Override
    public User mapCsvToObject(String[] objectCsv) {
        String id = objectCsv[1];
        String username = objectCsv[1];
        String password = objectCsv[2];
        String amountOfPassagers = objectCsv[3];
        Taxi taxi = TaxiService.getById(Integer.parseInt(objectCsv[4]));

        return new User(username, password, amountOfPassagers, taxi);
    }
}
