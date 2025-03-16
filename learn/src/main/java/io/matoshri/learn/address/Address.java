package io.matoshri.learn.address;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", unique = true)
    private Integer id;

    @Column(name = "area", length = 20)
    private String area;
    @Column(name = "city", length = 20)
    private String city;
    @Column(name = "pin_code", length = 10)
    private String pinCode;

    @Override
    public String toString() {
        return area + "," + city + "," + pinCode;
    }
}
