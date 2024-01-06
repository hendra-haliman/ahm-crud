package com.test.kendaraan.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.OverridesAttribute;

import org.springframework.stereotype.Component;

import com.test.kendaraan.constraint.NoRegistrasiConstraint;

@Component
public class NoRegistrasiConstraintValidator implements ConstraintValidator<NoRegistrasiConstraint, String> {

    private String noRegistrasiPrefix;

    @Override
    public void initialize(NoRegistrasiConstraint noRegistrasiConstraint) {
        noRegistrasiPrefix = noRegistrasiConstraint.value();
    }

    @Override
    public boolean isValid(String thePrefix, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;

        if (thePrefix != null) {
            result = thePrefix.startsWith(noRegistrasiPrefix);
        } else {
            result = true;
        }

        return result;

    }
}
