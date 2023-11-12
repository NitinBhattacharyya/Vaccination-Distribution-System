package com.vaccinationdistributionsystem.Vaccination.Distribution.System.Controller;

import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Entity.Doctor;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/api/doctor/add")
    public String addDoctoDB(@Valid @RequestBody Doctor doctor)
    {
        doctorService.createDoctor(doctor);
        return "Doctor added successfully.";
    }
}
