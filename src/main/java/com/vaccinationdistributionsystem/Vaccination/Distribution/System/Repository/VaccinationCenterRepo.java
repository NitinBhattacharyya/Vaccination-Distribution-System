package com.vaccinationdistributionsystem.Vaccination.Distribution.System.Repository;

import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Entity.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaccinationCenterRepo extends JpaRepository<VaccinationCenter,Integer> {

    List<VaccinationCenter> findByCenterName(String name);
}
