package ua.lviv.iot.Taxi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "taxi")
@Data
@NoArgsConstructor
public class Taxi {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "name")
    public String name;

    @Column(name = "car_number")
    public String carNumber;

    @Column(name = "payments")
    public String payments;

    public String[] toCsvFormat() {
        return new String[]{ "Taxi", this.name, this.carNumber, this.payments };
    }

    public Taxi(String name, String carNumber, String payments) {
        this.name = name;
        this.carNumber = carNumber;
        this.payments = payments;
    }
}
