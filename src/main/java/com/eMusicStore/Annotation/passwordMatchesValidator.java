package com.eMusicStore.Annotation;

import com.eMusicStore.entity.Customer;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class passwordMatchesValidator implements ConstraintValidator<passwordMatches, Object> {

    @Override
    public void initialize(passwordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Customer customer = (Customer) o;
        return customer.getPassword().equals(customer.getConfirmPassword());
    }
}
