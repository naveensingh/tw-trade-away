package com.nyss.thoughtworks.tradeAway.utilities;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_SINGLETON;


@Component
@Scope(SCOPE_SINGLETON)
public class InputValidator {
    private static final Pattern VALID_EMAIL =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private static final Pattern ALPHABETS_AND_SPACES_ONLY =
            Pattern.compile("[a-zA-Z ]*$");
    private static final Pattern ALPHABETS_ONLY =
            Pattern.compile("[a-zA-Z]+");
    private static final Pattern ALPHANUMERIC_ONLY =
            Pattern.compile("[a-zA-Z0-9]+");
    private static final Pattern NUMBERS_ONLY =
            Pattern.compile("^[0-9]*$");

    public String validateMaxLength(String fieldValue, String fieldName, int maxLength) {
        if (fieldValue != null) {
            boolean valid = fieldValue.length() <= maxLength;
            return valid ? "" : fieldName + " can not be longer than " + maxLength + " characters";
        }
        return "";
    }

    public String validateStringForAlphabetsAndSpacesOnly(String fieldValue, String fieldName) {
        if (fieldValue != null) {
            fieldValue = fieldValue.trim();
            boolean valid = ALPHABETS_AND_SPACES_ONLY.matcher(fieldValue).matches();
            return valid ? "" : fieldName + " can contain only alphabets and spaces";
        }
        return "";
    }

    public String validateStringForAlphabetsOnly(String fieldValue, String fieldName) {
        if (fieldValue != null) {
            fieldValue = fieldValue.trim();
            boolean valid = ALPHABETS_ONLY.matcher(fieldValue).matches();
            return valid ? "" : fieldName + " can contain only alphabets";
        }
        return "";
    }

    public String validateStringForAlphanumericCharacters(String fieldValue, String fieldName) {
        if (fieldValue != null) {
            fieldValue = fieldValue.trim();
            boolean valid = ALPHANUMERIC_ONLY.matcher(fieldValue).matches();
            return valid ? "" : fieldName + " can contain only characters and numbers";
        }
        return "";
    }

    public String validateStringForEmail(String email) {
        if (email != null) {
            email = email.trim();
            boolean valid = VALID_EMAIL.matcher(email).matches();
            return valid ? "" : "Email is not valid";
        }
        return "";
    }

    public String validateStringForNumbersOnly(String fieldValue, String fieldName) {
        if (fieldValue != null) {
            fieldValue = fieldValue.trim();
            boolean valid = NUMBERS_ONLY.matcher(fieldValue).matches();
            return valid ? "" : fieldName + " can contain only numbers";
        }
        return "";
    }

    public String validateStringNotEmpty(String fieldValue, String fieldName) {
        if (fieldValue != null) {
            fieldValue = fieldValue.trim();
            boolean valid = !"".equals(fieldValue);
            return valid ? "" : fieldName + " cannot be empty";
        }
        return "";
    }

    public String validateValidGenderOption(String gender) {
        boolean valid = "MALE".equals(gender) || "FEMALE".equals(gender) || "OTHERS".equals(gender);
        return valid ? "" : "Please pass only MALE, FEMALE or OTHERS in gender field";
    }

    public String validatePositiveIntegersFromInput(int fieldValue, String fieldName) {
        return (Math.signum(fieldValue) < 0 || Math.signum(fieldValue) == -1.0) ? fieldName + " should be a positive number" : "";
    }
}