package com.vaccinationdistributionsystem.Vaccination.Distribution.System.Controller;

import com.vaccinationdistributionsystem.Vaccination.Distribution.System.DRO.CenterNameDoseType;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Entity.VaccinationCenter;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Service.VaccinationCenterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VaccinationCenterController {

    @Autowired
    VaccinationCenterService vaccinationCenterService;

    @PostMapping("/api/vaccinationcenter/add")
    public String createVaccinationCenter(@Valid @RequestBody VaccinationCenter obj){
        vaccinationCenterService.createVaccinationCenter(obj);
        return "Hey Vaccination Center got created into database successfully";
    }

    @GetMapping("/api/vaccinationcenter")
    public List<VaccinationCenter> searchByName(@RequestParam String centerName)
    {
        return vaccinationCenterService.searchByName(centerName);
    }

    @GetMapping("/api/vaccinationcenter/{centerName}")
    public List<CenterNameDoseType> getParticularDoseCount(@PathVariable String centerName, @RequestParam String doseType)
    {
        return vaccinationCenterService.getParticularVaccinationCenterDoseCount(centerName,doseType);
    }
}
