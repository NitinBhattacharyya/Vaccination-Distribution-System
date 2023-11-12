package com.vaccinationdistributionsystem.Vaccination.Distribution.System.Service;

import com.vaccinationdistributionsystem.Vaccination.Distribution.System.DRO.VaccinationCenterVsDocCount;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Entity.Doctor;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Entity.VaccinationCenter;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Repository.DoctorRepo;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Repository.VaccinationCenterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    DoctorRepo doctorRepo;

    @Autowired
    VaccinationCenterRepo vaccinationCenterRepo;

    public void createDoctor(Doctor doctor)
    {
        VaccinationCenterVsDocCount vaccinationCenterVsDocCount=doctorRepo.getVaccinationCenterVsDocCount();
        Optional<VaccinationCenter> vaccinationCenter=vaccinationCenterRepo.findById(vaccinationCenterVsDocCount.getVcid());
        if(vaccinationCenter.isPresent())
        {
            doctor.setVaccinationCenter(vaccinationCenter.get());
            vaccinationCenter.get().getDoctors().add(doctor);
            doctorRepo.save(doctor);
        }
    }
}
