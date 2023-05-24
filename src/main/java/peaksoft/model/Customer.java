package peaksoft.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import peaksoft.enums.Gender;

import java.time.LocalDate;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Customer {
    @Id
    @GeneratedValue(generator = "costumer_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name ="costumer_gen",sequenceName = "costumer_seq",allocationSize = 1)
    private Long id;
    //@Size(min = 2, max = 33, message = "First name should be between 2 and 33 characters!")
    private String firstName;
    private String lastName;
    private String email;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private int age;
    private String phoneNumber;
    private LocalDate dataOfBirth;
    private String photo;

    @ManyToMany(cascade = {DETACH, MERGE,REFRESH,REMOVE})
    private List<Agency>agencies;
    @OneToMany(mappedBy = "customer",cascade = {DETACH, MERGE,REFRESH})
    private List<Booking>bookings;
}
