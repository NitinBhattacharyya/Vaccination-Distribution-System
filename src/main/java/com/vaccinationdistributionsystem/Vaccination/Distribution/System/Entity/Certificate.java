package com.vaccinationdistributionsystem.Vaccination.Distribution.System.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Certificate {

    @Id
    private String certificateId;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Patient patient;

}
