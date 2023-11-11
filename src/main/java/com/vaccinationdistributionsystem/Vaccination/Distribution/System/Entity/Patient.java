package com.vaccinationdistributionsystem.Vaccination.Distribution.System.Entity;

import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Enums.CenterPreference;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Enums.VaccinationPreference;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.annotation.Enum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;

    private String name;
    @Enum(enumClass = VaccinationPreference.class,ignoreCase = true)
    private String vaccinationPreference;
    @Enum(enumClass = CenterPreference.class,ignoreCase = true)
    private String centerPreference;
    @ManyToOne
    @JoinColumn(name = "vcid",referencedColumnName = "vcid")
    private VaccinationCenter vaccinationCenter;
    @ManyToOne
    @JoinColumn(name="doc_id",referencedColumnName = "docId")
    private Doctor doctor;
    @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
    @NotNull(message = "Phone number should not be blank")
    private String phoneNumber;
    @Column(unique = true)
    @Email(message = "Please provide valid email address")
    private String email;

    private boolean isVaccinated;

    @Column(unique = true)
    private int CertificateNumber;
}
