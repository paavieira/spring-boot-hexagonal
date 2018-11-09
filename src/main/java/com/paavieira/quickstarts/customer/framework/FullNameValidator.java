package com.paavieira.quickstarts.customer.framework;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

public class FullNameValidator implements
  ConstraintValidator<ValidFullName, CustomerEntity> {

    @Override
    public void initialize(ValidFullName contactNumber) {
    }

    @Override
    public boolean isValid(CustomerEntity customer, ConstraintValidatorContext cxt) {

		if (customer == null) return true;

		final String firstName = customer.getFirstName();
		final String lastName = customer.getLastName();

		final boolean isFirstNameEmpty = StringUtils.isEmpty(firstName);
		final boolean isLastNameEmpty = StringUtils.isEmpty(lastName);

		return !isFirstNameEmpty && !isLastNameEmpty;

    }

}