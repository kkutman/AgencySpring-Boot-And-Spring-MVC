package peaksoft.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Booking {
    @Id
    @GeneratedValue(generator = "booking_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "booking_gen", sequenceName = "booking_seq", allocationSize = 1)
    private Long id;
    @OneToOne(cascade = {DETACH, MERGE,REFRESH})
    private House house;
    @ManyToOne(cascade = {DETACH, MERGE,REFRESH,REMOVE})
    private Customer customer;
}
