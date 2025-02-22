package io.matoshri.learn.student;

import io.matoshri.learn.address.Address;
import io.matoshri.learn.college.College;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "student")
@Getter
@Setter
@EqualsAndHashCode(exclude = {"college", "address"})
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String studentName;
    @Email(message = "Enter valid email address for Student Email")
    private String studentEmail;
    private String studentClass;

    @ManyToOne
    @JoinColumn(name = "college_id")
    private College college;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @CreationTimestamp
    private LocalDateTime createdAd;

    public Student(String studentName, String studentEmail, String studentClass, College college, Address address) {
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentClass = studentClass;
        this.college = college;
        this.address = address;
    }


    @Override
    public String toString() {
        return new StringBuilder()
                .append("id=").append(id)
                .append(", studentName=").append(studentName)
                .append(", studentEmail=").append(studentEmail)
                .append(", studentClass=").append(studentClass)
                .append(", college=").append(college.getCollegeName())
                .append(", address=").append(address.toString())
                .toString();
    }
}
