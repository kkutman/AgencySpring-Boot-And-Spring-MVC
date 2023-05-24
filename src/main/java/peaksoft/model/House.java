package peaksoft.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import peaksoft.enums.HouseType;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "houses")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class House {
    @Id
    @GeneratedValue(generator = "house_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "house_gen", sequenceName = "house_seq", allocationSize = 1)
    private Long id;
    @Enumerated(EnumType.STRING)
    private HouseType houseType;
    private String address;
    private int price;
    private int room;
    private String country;
    private String description;
    private Boolean isBooked = true;
    @Transient
    private String houseTypeString;
    @ManyToOne(cascade = {DETACH, MERGE, REFRESH})
    private Agency agency;
    @OneToOne(mappedBy = "house", cascade = {DETACH, MERGE, REFRESH})
    private Booking booking;
}
