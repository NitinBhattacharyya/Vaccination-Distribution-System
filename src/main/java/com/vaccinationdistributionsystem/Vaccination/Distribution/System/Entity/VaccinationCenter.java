package com.vaccinationdistributionsystem.Vaccination.Distribution.System.Entity;

import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Enums.CenterPreference;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.annotation.Enum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class VaccinationCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vcid;

    @NotNull(message = "Center name cannot be null")
    private String centerName;

    private int covaxinDose;

    private int covishieldDose;

    private int sputnikDose;
    @Enum(enumClass = CenterPreference.class)
    private String type;

    private String address;
    @OneToMany(mappedBy = "vaccinationCenter",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST,targetEntity = Doctor.class)
    private Set<Doctor> doctors=new HashSet<>();

    @OneToMany(mappedBy = "vaccinationCenter")
    private Set<Patient> patients=new HashSet<>();




}
