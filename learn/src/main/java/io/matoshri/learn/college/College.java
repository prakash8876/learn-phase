package io.matoshri.learn.college;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.matoshri.learn.address.Address;
import io.matoshri.learn.student.Student;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"address", "students"})
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "college")
public class College implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "college_id", unique = true)
    private Integer id;

    @Column(name = "college_name", length = 100)
    private String collegeName;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @JsonIgnore
    @OneToMany(mappedBy = "college")
    private List<Student> students = new ArrayList<>();

    public College(String collegeName, Address address, List<Student> students) {
        this.collegeName = collegeName;
        this.address = address;
        this.students = students;
    }

    @Override
    public String toString() {
        return "College{" +
                "collegeId=" + id +
                ", collegeName='" + collegeName + '\'' +
                '}';
    }
}
