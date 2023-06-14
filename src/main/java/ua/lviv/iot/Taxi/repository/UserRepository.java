package ua.lviv.iot.Taxi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.Taxi.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}