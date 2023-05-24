package peaksoft.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "agencies")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Agency {
    @Id
    @GeneratedValue(generator = "agency_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "agency_gen",sequenceName = "agency_seq",allocationSize = 1)
    private Long id;
    private String name;
    private String country;
    private String phoneNumber;
    private String email;
    private String photo;
    @OneToMany(mappedBy = "agency",cascade = {ALL})
    private List<House> houses;
    @ManyToMany(cascade = {DETACH, MERGE,REFRESH})
    private List<Customer>costumers;
}
