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
    @NotNull
    private String name;
    @NotNull
    @Enum(enumClass = VaccinationPreference.class)
    private String vaccinationPreference;
    @NotNull
    @Enum(enumClass = CenterPreference.class)
    private String centerPreference;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "vcid",referencedColumnName = "vcid")
    private VaccinationCenter vaccinationCenter;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="doc_id",referencedColumnName = "docId")
    private Doctor doctor;
    @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
    @NotNull(message = "Phone number should not be blank")
    private String phoneNumber;
    @Column(unique = true)
    @Email(message = "Please provide valid email address")
    private String email;

    private boolean isVaccinated;
    @OneToOne
    @JoinColumn(name = "certificate_number",referencedColumnName = "certificateId")
    private Certificate  CertificateNumber;
}
