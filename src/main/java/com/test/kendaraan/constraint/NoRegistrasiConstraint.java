package com.test.kendaraan.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

@Constraint(validatedBy = NoRegistrasiConstraintValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NoRegistrasiConstraint {
    public String value() default "B";

    public String message() default "must start with B";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
