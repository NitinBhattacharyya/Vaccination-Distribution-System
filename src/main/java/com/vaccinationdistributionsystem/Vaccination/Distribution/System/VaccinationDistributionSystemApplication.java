package com.vaccinationdistributionsystem.Vaccination.Distribution.System;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Entity.Doctor;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Entity.VaccinationCenter;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Repository.VaccinationCenterRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class VaccinationDistributionSystemApplication {

	public static void main(String[] args) {

		SpringApplication.run(VaccinationDistributionSystemApplication.class, args);

	}

}
