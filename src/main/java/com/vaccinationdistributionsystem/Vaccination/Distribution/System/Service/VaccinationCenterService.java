package com.vaccinationdistributionsystem.Vaccination.Distribution.System.Service;

import com.vaccinationdistributionsystem.Vaccination.Distribution.System.DRO.CenterNameDoseType;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Entity.VaccinationCenter;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Repository.VaccinationCenterRepo;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VaccinationCenterService {

    @Autowired
    VaccinationCenterRepo vaccinationCenterRepo;

    public void createVaccinationCenter(VaccinationCenter vaccinationCenter)
    {
        vaccinationCenterRepo.save(vaccinationCenter);
    }

    public List<VaccinationCenter> searchByName(String name)
    {
        return vaccinationCenterRepo.findByCenterName(name);
    }

    public List<CenterNameDoseType> getParticularVaccinationCenterDoseCount(String centerName, String doseType) throws Exception {
        List<VaccinationCenter> list=vaccinationCenterRepo.findByCenterName(centerName);
        List<CenterNameDoseType> responseList=new ArrayList<>();
        for(VaccinationCenter vc: list)
        {
            try{

                Object doseValue=new BeanWrapperImpl(vc).getPropertyValue(doseType);
                responseList.add(new CenterNameDoseType(vc.getCenterName(),doseType,(Integer)doseValue));
            }
            catch (Exception e)
            {
                throw new Exception("Entered Dose Type Does not exist");
            }
        }
        return responseList;
    }
}
