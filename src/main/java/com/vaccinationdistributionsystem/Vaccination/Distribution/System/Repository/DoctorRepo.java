package com.vaccinationdistributionsystem.Vaccination.Distribution.System.Repository;

import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor,Integer> {

}
