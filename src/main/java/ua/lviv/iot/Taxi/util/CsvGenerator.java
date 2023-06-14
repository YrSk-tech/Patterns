package ua.lviv.iot.Taxi.util;

import com.opencsv.CSVWriter;
import org.jeasy.random.EasyRandom;
import ua.lviv.iot.Taxi.model.Route;
import ua.lviv.iot.Taxi.model.Taxi;
import ua.lviv.iot.Taxi.model.User;


import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CsvGenerator {
    public static void main(String[] args) throws IOException {
        List<String[]> data = new LinkedList<>();

        generateTaxiData(data);
        generateUserData(data);
        generateRouteData(data);

        try (CSVWriter writer = new CSVWriter(new FileWriter("data.csv"))) {
            writer.writeAll(data);
        }
    }

    private static void generateTaxiData(List<String[]> data) {
        EasyRandom generator = new EasyRandom();
        List<Taxi> taxis = generator.objects(Taxi.class, 200).collect(Collectors.toList());

        for (Taxi taxi : taxis) {
            data.add(taxi.toCsvFormat());
        }
    }

    private static void generateUserData(List<String[]> data) {
//        EasyRandom generator = new EasyRandom();
//        List<User> users = generator.objects(User.class, 200).collect(Collectors.toList());
//
//        for (User user : users) {
//            int addressId = Math.abs(user.getTaxi().getId() % 200);
//            if (addressId == 0) addressId++;
//
//            user.getTaxi().setId(addressId);
//            data.add(user.toCsvFormat());
//        }
    }

    private static void generateRouteData(List<String[]> data) {
//        EasyRandom generator = new EasyRandom();
//        List<Route> routes = generator.objects(Route.class, 200).collect(Collectors.toList());
//
//        for (Route route : routes) {
//            int userId = Math.abs(route.getUser().getId() % 200);
//            int TaxiId = Math.abs(route.getTaxi().getId() % 200);
//            if (userId == 0) userId++;
//            if (TaxiId == 0) TaxiId++;
//
//            route.getUser().setId(userId);
//            route.getTaxi().setId(TaxiId);
//
//            data.add(route.toCsvFormat());
//        }
    }
}
