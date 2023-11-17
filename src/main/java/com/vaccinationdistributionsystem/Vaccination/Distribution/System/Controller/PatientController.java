package com.vaccinationdistributionsystem.Vaccination.Distribution.System.Controller;

import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Entity.Patient;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/api/patient/add")
    public String createPatient(@Valid @RequestBody Patient patient)
    {
        patientService.createPatient(patient);
        return "Patient added successfully";
    }

    @PostMapping("/api/patient/giveDose")
    public String giveDose(@RequestParam String phoneNumber) throws Exception
    {
        patientService.giveDose(phoneNumber);
        return "Patient has been successfully vaccinated";
    }
}
