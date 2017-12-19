package com.nyss.thoughtworks.tradeAway.utilities;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class InputValidatorTest {
    @Test
    public void verifyStringsWithAppropriateLengthPassMaxLengthValidation() {
        InputValidator inputValidator = new InputValidator();
        String fieldValue = "9876543210";
        String fieldName = "fieldName";
        int acceptableMaxLength = 10;
        String expectedValidationOutput = "";

        String actualValidationOutput = inputValidator.validateMaxLength(fieldValue, fieldName, acceptableMaxLength);

        assertEquals(expectedValidationOutput, actualValidationOutput);
    }

    @Test
    public void verifyStringsWithInappropriateLengthFailMaxLengthValidation() {
        InputValidator inputValidator = new InputValidator();
        String fieldValue = "98765432100";
        String fieldName = "fieldName";
        int acceptableMaxLength = 10;
        String expectedValidationOutput = fieldName + " can not be longer than " + acceptableMaxLength + " characters";

        String actualValidationOutput = inputValidator.validateMaxLength(fieldValue, fieldName, acceptableMaxLength);

        assertEquals(expectedValidationOutput, actualValidationOutput);
    }

    @Test
    public void verifyInvalidEmailsFailValidationForEmail() {
        InputValidator inputValidator = new InputValidator();
        String email = "abc@thoughtworkscom";
        String expectedValidationOutput = "Email is not valid";

        String actualValidationOutput = inputValidator.validateStringForEmail(email);

        assertEquals(expectedValidationOutput, actualValidationOutput);
    }

    @Test
    public void verifyValidEmailsPassValidationForEmail() {
        InputValidator inputValidator = new InputValidator();
        String email = "abc@thoughtworks.com";
        String expectedValidationOutput = "";

        String actualValidationOutput = inputValidator.validateStringForEmail(email);

        assertEquals(expectedValidationOutput, actualValidationOutput);
    }

    @Test
    public void verifyValidationForAlphanumericsOnlyPassesForAlphanumericsOnly() {
        InputValidator inputValidator = new InputValidator();
        String fieldName = "fieldName";
        String fieldValue = "12345abcDFG";
        String expectedValidationOutput = "";

        String actualValidationOutput = inputValidator.validateStringForAlphanumericCharacters(fieldValue, fieldName);

        assertEquals(expectedValidationOutput, actualValidationOutput);
    }

    @Test
    public void verifyValidationForAlphanumericsOnlyFailsForSpecialCharacters() {
        InputValidator inputValidator = new InputValidator();
        String fieldName = "fieldName";
        String fieldValue = "12345#";
        String expectedValidationOutput = fieldName + " can contain only characters and numbers";

        String actualValidationOutput = inputValidator.validateStringForAlphanumericCharacters(fieldValue, fieldName);

        assertEquals(expectedValidationOutput, actualValidationOutput);
    }

    @Test
    public void verifyNumbersOnlyValidationPassesForAllNumericInput() {
        InputValidator inputValidator = new InputValidator();
        String fieldName = "fieldName";
        String fieldValue = "12345";
        String expectedValidationOutput = "";

        String actualValidationOutput = inputValidator.validateStringForNumbersOnly(fieldValue, fieldName);

        assertEquals(expectedValidationOutput, actualValidationOutput);
    }

    @Test
    public void verifyNumbersOnlyValidationFailsForNonNumericInput() {
        InputValidator inputValidator = new InputValidator();
        String fieldName = "fieldName";
        String fieldValue = "rerwe123ab";
        String expectedValidationOutput = fieldName + " can contain only numbers";

        String actualValidationOutput = inputValidator.validateStringForNumbersOnly(fieldValue, fieldName);

        assertEquals(expectedValidationOutput, actualValidationOutput);
    }

    @Test
    public void verifyEmptyStringFailsNonEmptyStringValidationCheck() {
        InputValidator inputValidator = new InputValidator();
        String fieldName = "fieldName";
        String fieldValue = "";
        String expectedValidationOutput = fieldName + " cannot be empty";

        String actualValidationOutput = inputValidator.validateStringNotEmpty(fieldValue, fieldName);

        assertEquals(expectedValidationOutput, actualValidationOutput);
    }

    @Test
    public void verifyNonEmptyStringPassesNonEmptyStringValidationCheck() {
        InputValidator inputValidator = new InputValidator();
        String fieldName = "fieldName";
        String fieldValue = "ABCDabcd";
        String expectedValidationOutput = "";

        String actualValidationOutput = inputValidator.validateStringNotEmpty(fieldValue, fieldName);

        assertEquals(expectedValidationOutput, actualValidationOutput);
    }

    @Test
    public void verifyAllAlphabetsInputValidationPassesForAllAlphabetsInput() {
        InputValidator inputValidator = new InputValidator();
        String fieldName = "fieldName";
        String fieldValue = "ABCDabcd";
        String expectedValidationOutput = "";

        String actualValidationOutput = inputValidator.validateStringForAlphabetsOnly(fieldValue, fieldName);

        assertEquals(expectedValidationOutput, actualValidationOutput);
    }

    @Test
    public void verifyAllAlphabetsInputValidationReturnsErrorForWrongInput() {
        InputValidator inputValidator = new InputValidator();
        String fieldName = "fieldName";
        String fieldValue = "A213B ccd";
        String expectedValidationOutput = fieldName + " can contain only alphabets";

        String actualValidationOutput = inputValidator.validateStringForAlphabetsOnly(fieldValue, fieldName);

        assertEquals(expectedValidationOutput, actualValidationOutput);
    }

    @Test
    public void verifyAlphabetsAndSpacesValidationPassesForAlphabetsAndSpaces() {
        InputValidator inputValidator = new InputValidator();
        String fieldName = "fieldName";
        String fieldValue = "ABB ccd ".trim();
        String expectedValidationOutput = "";

        String actualValidationOutput = inputValidator.validateStringForAlphabetsAndSpacesOnly(fieldValue, fieldName);

        assertEquals(expectedValidationOutput, actualValidationOutput);
    }

    @Test
    public void verifyAlphabetsAndSpacesValidationReturnsErrorForWrongInput() {
        InputValidator inputValidator = new InputValidator();
        String fieldName = "fieldName";
        String fieldValue = "  9".trim();
        String expectedValidationOutput = fieldName + " can contain only alphabets and spaces";

        String actualValidationOutput = inputValidator.validateStringForAlphabetsAndSpacesOnly(fieldValue, fieldName);

        assertEquals(expectedValidationOutput, actualValidationOutput);
    }

    @Test
    public void verifyValidGenderValuesPassTheValidationForGenders() {
        InputValidator inputValidator = new InputValidator();
        String firstPossibleFieldValue = "MALE";
        String secondPossibleFieldValue = "FEMALE";
        String thirdPossibleFieldValue = "OTHERS";
        String expectedValidationOutput = "";

        String firstActualValidationOutput = inputValidator.validateValidGenderOption(firstPossibleFieldValue);
        String secondActualValidationOutput = inputValidator.validateValidGenderOption(secondPossibleFieldValue);
        String thirdActualValidationOutput = inputValidator.validateValidGenderOption(thirdPossibleFieldValue);

        assertEquals(expectedValidationOutput, firstActualValidationOutput);
        assertEquals(expectedValidationOutput, secondActualValidationOutput);
        assertEquals(expectedValidationOutput, thirdActualValidationOutput);
    }

    @Test
    public void verifyInvalidGenderValuesDoNotPassTheValidationForGenders() {
        InputValidator inputValidator = new InputValidator();
        String fieldValue = "Axbd";
        String expectedValidationOutput = "Please pass only MALE, FEMALE or OTHERS in gender field";

        String actualValidationOutput = inputValidator.validateValidGenderOption(fieldValue);

        assertEquals(expectedValidationOutput, actualValidationOutput);
    }
}