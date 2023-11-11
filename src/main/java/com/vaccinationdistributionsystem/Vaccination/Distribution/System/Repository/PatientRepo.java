package com.vaccinationdistributionsystem.Vaccination.Distribution.System.Repository;

import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends JpaRepository<Patient,Integer> {
}
