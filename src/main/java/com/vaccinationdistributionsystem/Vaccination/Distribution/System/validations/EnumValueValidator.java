package com.vaccinationdistributionsystem.Vaccination.Distribution.System.validations;

import com.vaccinationdistributionsystem.Vaccination.Distribution.System.annotation.Enum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EnumValueValidator implements ConstraintValidator<Enum,String> {

    Enum annotation;
    @Override
    public void initialize(Enum annotation) {
        this.annotation=annotation;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean result=false;
        Object[] enumValues=this.annotation.enumClass().getEnumConstants();
        if(enumValues!=null)
        {
            for(Object enumValue:enumValues)
            {
                if(value.equalsIgnoreCase(enumValue.toString()))
                {
                    result=true;
                    break;
                }
            }
        }
        return result;
    }
}
