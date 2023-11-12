package com.vaccinationdistributionsystem.Vaccination.Distribution.System.Entity;

import com.vaccinationdistributionsystem.Vaccination.Distribution.System.DRO.VaccinationCenterVsDocCount;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Service.VaccinationCenterService;
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
@SqlResultSetMapping(name = "VaccinationCenterVsDoctorMapping",classes = @ConstructorResult(
        targetClass = VaccinationCenterVsDocCount.class,
        columns = {
                @ColumnResult(name = "vcid",type = int.class),
                @ColumnResult(name = "num_doctors",type = int.class)
        }
))
@NamedNativeQuery(name ="Doctor.getVaccinationCenterVsDocCount" ,query = "SELECT vc.vcid, COUNT(d.doc_id) AS num_doctors\n" +
        "FROM vaccination_center  vc\n" +
        "LEFT JOIN doctor d ON vc.vcid = d.vcid\n" +
        "GROUP BY vc.vcid\n" +
        "ORDER BY num_doctors ASC\n"+
        "LIMIT 1;",resultSetMapping = "VaccinationCenterVsDoctorMapping")
//resultClass attribute only takes entity classes,not for DTOs
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
