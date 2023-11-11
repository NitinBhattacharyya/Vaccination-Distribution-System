package com.vaccinationdistributionsystem.Vaccination.Distribution.System.DRO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CenterNameDoseType {
    String centerName;

    String doseType;

    int doseCount;
}
