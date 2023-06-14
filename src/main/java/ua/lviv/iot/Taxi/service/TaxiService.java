package ua.lviv.iot.Taxi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.Taxi.model.Taxi;
import ua.lviv.iot.Taxi.repository.TaxiRepository;

@Service
public class TaxiService extends AbstractService<Taxi> {
    @Autowired
    public TaxiService(TaxiRepository repository) {
        super(repository);
    }

    @Override
    public Taxi mapCsvToObject(String[] objectCsv) {
        String name = objectCsv[1];
        String carNumber = objectCsv[2];
        String payments = objectCsv[3];

        return new Taxi(name, carNumber, payments);
    }
}

