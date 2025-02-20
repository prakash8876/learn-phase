package io.matoshri.learn.address;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String area;
    private String city;
    private String pinCode;

    @Override
    public String toString() {
        return new StringBuilder().append(area).append(", ").append(city).append(", ").append(pinCode).toString();
    }
}
