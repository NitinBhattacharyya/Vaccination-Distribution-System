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
@NamedNativeQuery(name = "Doctor.findDocWithMinPatientsInGivenVaccinationCenter",query = "select  doc.* from doctor doc\n" +
        "left join patient p on doc.doc_id=p.doc_id \n" +
        "where doc.vcid= :vcid \n" +
        "group by doc.doc_id\n" +
        "order by count(p.pid) asc \n" +
        "limit 1;",resultClass = Doctor.class)
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
    @OneToMany(mappedBy = "doctor",cascade = CascadeType.PERSIST)
    private Set<Patient> patients=new HashSet<>();
}
