package com.etiya.ecommercedemopair1.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="plate_number")
    private int plateNumber;

    @ManyToOne
    @JoinColumn(name="country_id")
    private Country country;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "city",cascade = CascadeType.ALL)
    private List<Address> addresses;

}
