package com.nyss.thoughtworks.tradeAway.utilities;

import org.junit.Assert;
import org.junit.Test;

public class InputValidatorTest {
    @Test
    public void shouldVerifyIfStringHasOnlyAlphabets() {
        InputValidator inputValidator = new InputValidator();
        Assert.assertTrue(inputValidator.validateStringForAlphanumericCharacters("john"));
    }

    @Test
    public void shouldVerifyIfStringWithSpecialCharactersIsInValid() {
        InputValidator inputValidator = new InputValidator();
        Assert.assertFalse(inputValidator.validateStringForAlphanumericCharacters("john!@$$!@!"));
    }

    @Test
    public void shouldVerifyIfStringWithNumbersIsValid() {
        InputValidator inputValidator = new InputValidator();
        Assert.assertTrue(inputValidator.validateStringForAlphanumericCharacters("john1241351"));
    }

    @Test
    public void shouldVerifyIfEmptyStringIsInValid() {
        InputValidator inputValidator = new InputValidator();
        Assert.assertFalse(inputValidator.validateStringForAlphanumericCharacters(""));

    }

    @Test
    public void shouldVerifyIfNullProvidedAsStringIsInValid() {
        InputValidator inputValidator = new InputValidator();
        Assert.assertFalse(inputValidator.validateStringForAlphanumericCharacters(null));

    }

    @Test
    public void shouldVerifyIfEmailIsValid() {
        InputValidator inputValidator = new InputValidator();
        Assert.assertTrue(inputValidator.validateStringForEmail("contact@naveensingh.net"));
    }

    @Test
    public void shouldVerifyIfEmailIsInvalid() {
        InputValidator inputValidator = new InputValidator();
        Assert.assertFalse(inputValidator.validateStringForEmail("cont$£act@naveensingh.net"));
    }

    @Test
    public void shouldVerifyIfPhoneNumberIsValid() {
        InputValidator inputValidator = new InputValidator();
        Assert.assertTrue(inputValidator.validateStringForNumbers("0123456789"));
    }

    @Test
    public void shouldVerifyIfPhoneNumberIsInvalid() {
        InputValidator inputValidator = new InputValidator();
        Assert.assertFalse(inputValidator.validateStringForNumbers("0123456789R"));
    }

    @Test
    public void shouldVerifyIfStringIsAlphbaetsOnly() {
        InputValidator inputValidator = new InputValidator();
        Assert.assertTrue(inputValidator.validateStringForAlphabetsOnly("MALE"));
    }

    @Test
    public void shouldVerifyIfDateStringIsAValid() {
        InputValidator inputValidator = new InputValidator();
        Assert.assertTrue(inputValidator.validateStringForAlphabetsOnly("MALE"));
    }

}
