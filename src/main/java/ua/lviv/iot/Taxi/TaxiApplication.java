package ua.lviv.iot.Taxi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ua.lviv.iot.Taxi.service.DBLoaderService;

@SpringBootApplication
public class TaxiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(TaxiApplication.class, args);
		context.getBean(DBLoaderService.class).dumpCsvToDB("data.csv");
	}
}