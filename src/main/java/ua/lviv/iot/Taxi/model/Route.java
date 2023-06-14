package ua.lviv.iot.Taxi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
//@Table(name = "route")
@Data
@NoArgsConstructor
public class Route {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pick_up")
    private String pickUp;

    @Column(name = "destination")
    private String destination;

//    @ManyToOne
//    @JoinColumn(name = "taxi_driver_id", referencedColumnName = "id", nullable = false)
//    private Taxi Taxi;
//
//    @OneToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
//    private User user;

    public Route( String pickUp, String destination, User user, Taxi Taxi) {
        this.pickUp = pickUp;
        this.destination = destination;
//        this.user = user;
//        this.Taxi = Taxi;
    }
    public String[] toCsvFormat() {
        return new String[]{ "Route", this.pickUp, this.destination};
//                this.user.getId().toString(), this.Taxi.getId().toString() };
    }
}
