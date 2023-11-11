package com.vaccinationdistributionsystem.Vaccination.Distribution.System.Service;

import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    DoctorRepo doctorRepo;
}
