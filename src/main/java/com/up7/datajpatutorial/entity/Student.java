package com.up7.datajpatutorial.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "students",
        uniqueConstraints = @UniqueConstraint(columnNames = {"student_email"})
)
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1,
            initialValue = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long studentId;

    @Column(
            name = "student_first_name",
            nullable = false
    )
    private String studentFirstName;

    @Column(
            name = "student_last_name",
            nullable = false
    )
    private String studentLastName;

    @Column(
            name = "student_email",
            nullable = false
    )
    private String studentEmail;

    @Embedded
    private Guardian guardian;

}
