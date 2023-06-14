package ua.lviv.iot.Taxi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "AmountOfPassagers")
    private String amountOfPassagers;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "taxi_driver", referencedColumnName = "id", nullable = true)
    private Taxi Taxi;

    public User(String username, String password, String amountOfPassagers, Taxi Taxi) {
        this.username = username;
        this.password = password;
        this.amountOfPassagers = amountOfPassagers;
        this.Taxi = Taxi;
    }
    public String[] toCsvFormat() {
        return new String[]{ "USER", this.username, this.password, this.amountOfPassagers,
                this.Taxi.getId().toString() };
    }
}

