package com.vaccinationdistributionsystem.Vaccination.Distribution.System.Service;

import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Entity.Doctor;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Entity.Patient;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Entity.VaccinationCenter;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Repository.DoctorRepo;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Repository.PatientRepo;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Repository.VaccinationCenterRepo;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientRepo patientRepo;

    @Autowired
    VaccinationCenterRepo vaccinationCenterRepo;

    @Autowired
    DoctorRepo doctorRepo;

    public void createPatient(Patient patient)
    {
        patient.setCenterPreference(patient.getCenterPreference().toUpperCase());
        patient.setVaccinationPreference(patient.getVaccinationPreference().toLowerCase());
        List<VaccinationCenter> vc= vaccinationCenterRepo.findVaccinationCenterWithMinPatients(patient.getCenterPreference());
        String doseType=patient.getVaccinationPreference()+"Dose";
        VaccinationCenter desiredVaccinationCenter=new VaccinationCenter();
        boolean flag=false;
        for(VaccinationCenter vaccinationCenter:vc)
        {
            Integer countOfDesiredDoseType= (Integer) new BeanWrapperImpl(vaccinationCenter).getPropertyValue(doseType);
            if(countOfDesiredDoseType>0 && vaccinationCenter.getDoctors().size()>0)
            {
                desiredVaccinationCenter=vaccinationCenter;
                flag=true;
                break;
            }
        }
        if(!flag)
        {
            for(VaccinationCenter vaccinationCenter:vc)
            {
                if(vaccinationCenter.getDoctors().size()>0)
                {
                    desiredVaccinationCenter=vaccinationCenter;
                    break;
                }
            }
        }

        desiredVaccinationCenter.getPatients().add(patient);
        patient.setVaccinationCenter(desiredVaccinationCenter);
        Doctor doctor=doctorRepo.findDocWithMinPatientsInGivenVaccinationCenter(desiredVaccinationCenter.getVcid());
        patient.setDoctor(doctor);
        doctor.getPatients().add(patient);
        doctor.setPatientCount(doctor.getPatients().size());
        patientRepo.save(patient);



    }


}
