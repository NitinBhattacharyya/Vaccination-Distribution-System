package com.vaccinationdistributionsystem.Vaccination.Distribution.System.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int docId;
    @NotNull(message = "Doctor Name cannot be empty")
    private String docName;
    @NotNull(message = "Doctor degree cannot be empty")
    private String docDegree;
    @ManyToOne(cascade = CascadeType.PERSIST,targetEntity = VaccinationCenter.class)
    @JoinColumn(name = "vcid",referencedColumnName = "vcid")
    private VaccinationCenter vaccinationCenter;

    private int patientCount;
    @OneToMany(mappedBy = "doctor")
    private Set<Patient> patients=new HashSet<>();
}
