package com.nyss.thoughtworks.tradeAway.utilities;

import com.nyss.thoughtworks.tradeAway.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_SINGLETON;

@Component
@Scope(SCOPE_SINGLETON)
public class UserValidator {

    @Autowired
    private InputValidator inputValidator;

    public List<String> validate(User user) {
        Set<String> errors = new HashSet<>();

        errors.add(inputValidator.validateStringNotEmpty(user.getUsername(), "Username"));
        errors.add(inputValidator.validateStringForAlphanumericCharacters(user.getUsername(), "Username"));
        errors.add(inputValidator.validateStringNotEmpty(user.getName(), "Name"));
        errors.add(inputValidator.validateStringForAlphabetsAndSpacesOnly(user.getName(), "Name"));
        errors.add(inputValidator.validateStringNotEmpty(user.getPassword(), "Password"));
        errors.add(inputValidator.validateStringForAlphanumericCharacters(user.getPassword(), "Password"));
        errors.add(inputValidator.validateStringNotEmpty(user.getEmailId(), "Email"));
        errors.add(inputValidator.validateStringForEmail(user.getEmailId()));
        errors.add(inputValidator.validateStringNotEmpty(user.getAddress(), "Address"));
        errors.add(inputValidator.validateStringForAlphanumericCharacters(user.getAddress(), "Address"));
        errors.add(inputValidator.validateStringForNumbersOnly(user.getMobile(), "Mobile"));
        errors.add(inputValidator.validateMaxLength(user.getMobile(), "Mobile", 10));
        errors.add(inputValidator.validateStringNotEmpty(user.getGender(), "Gender"));
        errors.add(inputValidator.validateStringForAlphabetsOnly(user.getGender(), "Gender"));
        errors.add(inputValidator.validateValidGenderOption(user.getGender()));

        errors.remove("");
        return new ArrayList<>(errors);
    }
}
