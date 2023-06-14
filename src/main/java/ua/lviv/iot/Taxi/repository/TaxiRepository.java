package ua.lviv.iot.Taxi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.Taxi.model.Taxi;


@Repository
public interface TaxiRepository extends JpaRepository<Taxi, Integer> {
}
