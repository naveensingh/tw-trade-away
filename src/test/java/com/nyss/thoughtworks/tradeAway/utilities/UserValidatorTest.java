package com.nyss.thoughtworks.tradeAway.utilities;

import com.nyss.thoughtworks.tradeAway.models.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserValidatorTest {

    @InjectMocks
    private UserValidator userValidator;

    @Mock
    private InputValidator inputValidator;


    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void verifyNoErrorIsReturnedForValidBuyerInput() {
        User user = new User();
        user.setUserType("BUYER");
        when(inputValidator.validateStringForEmail(any())).thenReturn("");
        when(inputValidator.validateStringNotEmpty(any(), any())).thenReturn("");
        when(inputValidator.validateStringForAlphanumericCharacters(any(), any())).thenReturn("");
        when(inputValidator.validateStringForAlphabetsOnly(any(), any())).thenReturn("");
        when(inputValidator.validateStringForNumbersOnly(any(), any())).thenReturn("");
        when(inputValidator.validateStringForAlphabetsAndSpacesOnly(any(), any())).thenReturn("");
        when(inputValidator.validateMaxLength(any(), any(), anyInt())).thenReturn("");
        when(inputValidator.validateValidGenderOption(any())).thenReturn("");
        when(inputValidator.validateStringNotEmpty(any(), any())).thenReturn("");
        when(inputValidator.validateUserTypeOption("BUYER")).thenReturn("");

        List<String> errorMessages = userValidator.validate(user);

        verify(inputValidator, times(1)).validateStringNotEmpty(user.getUserType(), "UserType");
        verify(inputValidator, times(1)).validateUserTypeOption(user.getUserType());
        verify(inputValidator, times(1)).validateStringNotEmpty(user.getUsername(), "Username");
        verify(inputValidator, times(1)).validateStringForAlphanumericCharacters(user.getUsername(), "Username");
        verify(inputValidator, times(1)).validateStringNotEmpty(user.getName(), "Name");
        verify(inputValidator, times(1)).validateStringForAlphabetsAndSpacesOnly(user.getName(), "Name");
        verify(inputValidator, times(1)).validateStringNotEmpty(user.getPassword(), "Password");
        verify(inputValidator, times(1)).validateStringForAlphanumericCharacters(user.getPassword(), "Password");
        verify(inputValidator, times(1)).validateStringNotEmpty(user.getEmailId(), "Email");
        verify(inputValidator, times(1)).validateStringForEmail(user.getEmailId());
        verify(inputValidator, times(1)).validateStringNotEmpty(user.getAddress(), "Address");
        verify(inputValidator, times(1)).validateStringForAlphanumericCharacters(user.getAddress(), "Address");
        verify(inputValidator, times(1)).validateStringForNumbersOnly(user.getMobile(), "Mobile");
        verify(inputValidator, times(1)).validateMaxLength(user.getMobile(), "Mobile", 10);
        verify(inputValidator, times(1)).validateStringNotEmpty(user.getGender(), "Gender");
        verify(inputValidator, times(1)).validateStringForAlphabetsOnly(user.getGender(), "Gender");
        verify(inputValidator, times(1)).validateValidGenderOption(user.getGender());

        assertTrue(errorMessages.isEmpty());
    }
    @Test
    public void verifyNoErrorIsReturnedForValidSellerInput() {
        User user = new User();
        user.setUserType("SELLER");
        when(inputValidator.validateStringForEmail(any())).thenReturn("");
        when(inputValidator.validateStringNotEmpty(any(), any())).thenReturn("");
        when(inputValidator.validateStringForAlphanumericCharacters(any(), any())).thenReturn("");
        when(inputValidator.validateStringForAlphabetsOnly(any(), any())).thenReturn("");
        when(inputValidator.validateStringForNumbersOnly(any(), any())).thenReturn("");
        when(inputValidator.validateStringForAlphabetsAndSpacesOnly(any(), any())).thenReturn("");
        when(inputValidator.validateMaxLength(any(), any(), anyInt())).thenReturn("");
        when(inputValidator.validateValidGenderOption(any())).thenReturn("");
        when(inputValidator.validateStringNotEmpty(any(), any())).thenReturn("");
        when(inputValidator.validatePositiveIntegersFromInput(anyInt(), any())).thenReturn("");

        when(inputValidator.validateUserTypeOption("SELLER")).thenReturn("");

        List<String> errorMessages = userValidator.validate(user);

        verify(inputValidator, times(1)).validatePositiveIntegersFromInput(user.getExperience(), "Experience");
        verify(inputValidator, times(1)).validateStringForAlphabetsOnly(user.getPanNumber(), "PAN Number");
        verify(inputValidator, times(1)).validateStringNotEmpty(user.getPanNumber(), "PAN Number");
        verify(inputValidator, times(1)).validateStringNotEmpty(user.getUserType(), "UserType");
        verify(inputValidator, times(1)).validateUserTypeOption(user.getUserType());
        verify(inputValidator, times(1)).validateStringNotEmpty(user.getUsername(), "Username");
        verify(inputValidator, times(1)).validateStringForAlphanumericCharacters(user.getUsername(), "Username");
        verify(inputValidator, times(1)).validateStringNotEmpty(user.getName(), "Name");
        verify(inputValidator, times(1)).validateStringForAlphabetsAndSpacesOnly(user.getName(), "Name");
        verify(inputValidator, times(1)).validateStringNotEmpty(user.getPassword(), "Password");
        verify(inputValidator, times(1)).validateStringForAlphanumericCharacters(user.getPassword(), "Password");
        verify(inputValidator, times(1)).validateStringNotEmpty(user.getEmailId(), "Email");
        verify(inputValidator, times(1)).validateStringForEmail(user.getEmailId());
        verify(inputValidator, times(1)).validateStringNotEmpty(user.getAddress(), "Address");
        verify(inputValidator, times(1)).validateStringForAlphanumericCharacters(user.getAddress(), "Address");
        verify(inputValidator, times(1)).validateStringForNumbersOnly(user.getMobile(), "Mobile");
        verify(inputValidator, times(1)).validateMaxLength(user.getMobile(), "Mobile", 10);
        verify(inputValidator, times(1)).validateStringNotEmpty(user.getGender(), "Gender");
        verify(inputValidator, times(1)).validateStringForAlphabetsOnly(user.getGender(), "Gender");
        verify(inputValidator, times(1)).validateValidGenderOption(user.getGender());

        assertTrue(errorMessages.isEmpty());
    }

    @Test
    public void verifyThatSellerMustHaveExperienceAndPanNumber() {
        User user = new User();
        user.setUserType("SELLER");
        user.setPanNumber("");
        user.setExperience(3);
        String errorMessage = "PAN Number cannot be empty";

        when(inputValidator.validateStringForEmail(any())).thenReturn("");
        when(inputValidator.validateStringNotEmpty(any(), any())).thenReturn("");
        when(inputValidator.validateStringForAlphanumericCharacters(any(), any())).thenReturn("");
        when(inputValidator.validateStringForAlphabetsOnly(any(), any())).thenReturn("");
        when(inputValidator.validateStringForNumbersOnly(any(), any())).thenReturn("");
        when(inputValidator.validateStringForAlphabetsAndSpacesOnly(any(), any())).thenReturn("");
        when(inputValidator.validateMaxLength(any(), any(), anyInt())).thenReturn("");
        when(inputValidator.validateValidGenderOption(any())).thenReturn("");
        when(inputValidator.validateStringNotEmpty(any(), any())).thenReturn("");
        when(inputValidator.validatePositiveIntegersFromInput(anyInt(), any())).thenReturn(errorMessage);
        when(inputValidator.validateUserTypeOption(any())).thenReturn("");

        List<String> errorMessages = userValidator.validate(user);

        verify(inputValidator, times(1)).validatePositiveIntegersFromInput(user.getExperience(), "Experience");
        verify(inputValidator, times(1)).validateStringNotEmpty(user.getPanNumber(), "PAN Number");
        verify(inputValidator, times(1)).validateStringForAlphabetsOnly(user.getPanNumber(), "PAN Number");

        assertTrue(errorMessages.size() == 1);
        assertTrue(errorMessages.contains(errorMessage));
    }

    @Test
    public void verifySingleErrorIsReturnedForSingleErrorInUserInput() {
        User user = new User();
        user.setUserType("SELLER");
        String emailValidationError = "Validation Error";
        when(inputValidator.validatePositiveIntegersFromInput(anyInt(), any())).thenReturn("");
        when(inputValidator.validateUserTypeOption("SELLER")).thenReturn("");
        when(inputValidator.validateStringForEmail(any())).thenReturn(emailValidationError);
        when(inputValidator.validateStringNotEmpty(any(), any())).thenReturn("");
        when(inputValidator.validateStringForAlphanumericCharacters(any(), any())).thenReturn("");
        when(inputValidator.validateStringForAlphabetsOnly(any(), any())).thenReturn("");
        when(inputValidator.validateStringForNumbersOnly(any(), any())).thenReturn("");
        when(inputValidator.validateStringForAlphabetsAndSpacesOnly(any(), any())).thenReturn("");
        when(inputValidator.validateMaxLength(any(), any(), anyInt())).thenReturn("");
        when(inputValidator.validateValidGenderOption(any())).thenReturn("");

        List<String> errorMessages = userValidator.validate(user);

        verify(inputValidator, times(1)).validateStringNotEmpty(user.getUsername(), "Username");
        verify(inputValidator, times(1)).validateStringForAlphanumericCharacters(user.getUsername(), "Username");
        verify(inputValidator, times(1)).validateStringNotEmpty(user.getName(), "Name");
        verify(inputValidator, times(1)).validateStringForAlphabetsAndSpacesOnly(user.getName(), "Name");
        verify(inputValidator, times(1)).validateStringNotEmpty(user.getPassword(), "Password");
        verify(inputValidator, times(1)).validateStringForAlphanumericCharacters(user.getPassword(), "Password");
        verify(inputValidator, times(1)).validateStringNotEmpty(user.getEmailId(), "Email");
        verify(inputValidator, times(1)).validateStringForEmail(user.getEmailId());
        verify(inputValidator, times(1)).validateStringNotEmpty(user.getAddress(), "Address");
        verify(inputValidator, times(1)).validateStringForAlphanumericCharacters(user.getAddress(), "Address");
        verify(inputValidator, times(1)).validateStringForNumbersOnly(user.getMobile(), "Mobile");
        verify(inputValidator, times(1)).validateMaxLength(user.getMobile(), "Mobile", 10);
        verify(inputValidator, times(1)).validateStringNotEmpty(user.getGender(), "Gender");
        verify(inputValidator, times(1)).validateStringForAlphabetsOnly(user.getGender(), "Gender");
        verify(inputValidator, times(1)).validateValidGenderOption(user.getGender());

        assertTrue(errorMessages.size() == 1);
        assertTrue(errorMessages.contains(emailValidationError));
    }

    @Test
    public void verifyMultipleErrorsAreReturnedForMultipleErrorsInUserInput() {
        User user = new User();
        user.setUserType("SELLER");
        String emailValidationError = "Validation Error";
        String genderValidationError = "Gender can contain only alphabets";user.setUserType("SELLER");
        when(inputValidator.validatePositiveIntegersFromInput(anyInt(), any())).thenReturn("");
        when(inputValidator.validateUserTypeOption("SELLER")).thenReturn("");
        when(inputValidator.validateStringForEmail(any())).thenReturn(emailValidationError);
        when(inputValidator.validateStringNotEmpty(any(), any())).thenReturn("");
        when(inputValidator.validateStringForAlphanumericCharacters(any(), any())).thenReturn("");
        when(inputValidator.validateStringForAlphabetsOnly(any(), any())).thenReturn(genderValidationError);
        when(inputValidator.validateStringForNumbersOnly(any(), any())).thenReturn("");
        when(inputValidator.validateStringForAlphabetsAndSpacesOnly(any(), any())).thenReturn("");
        when(inputValidator.validateMaxLength(any(), any(), anyInt())).thenReturn("");
        when(inputValidator.validateValidGenderOption(any())).thenReturn("");

        List<String> errorMessages = userValidator.validate(user);

        verify(inputValidator, times(1)).validateStringNotEmpty(user.getUsername(), "Username");
        verify(inputValidator, times(1)).validateStringForAlphanumericCharacters(user.getUsername(), "Username");
        verify(inputValidator, times(1)).validateStringNotEmpty(user.getName(), "Name");
        verify(inputValidator, times(1)).validateStringForAlphabetsAndSpacesOnly(user.getName(), "Name");
        verify(inputValidator, times(1)).validateStringNotEmpty(user.getPassword(), "Password");
        verify(inputValidator, times(1)).validateStringForAlphanumericCharacters(user.getPassword(), "Password");
        verify(inputValidator, times(1)).validateStringNotEmpty(user.getEmailId(), "Email");
        verify(inputValidator, times(1)).validateStringForEmail(user.getEmailId());
        verify(inputValidator, times(1)).validateStringNotEmpty(user.getAddress(), "Address");
        verify(inputValidator, times(1)).validateStringForAlphanumericCharacters(user.getAddress(), "Address");
        verify(inputValidator, times(1)).validateStringForNumbersOnly(user.getMobile(), "Mobile");
        verify(inputValidator, times(1)).validateMaxLength(user.getMobile(), "Mobile", 10);
        verify(inputValidator, times(1)).validateStringNotEmpty(user.getGender(), "Gender");
        verify(inputValidator, times(1)).validateStringForAlphabetsOnly(user.getGender(), "Gender");
        verify(inputValidator, times(1)).validateValidGenderOption(user.getGender());

        assertTrue(errorMessages.size() == 2);
        assertTrue(errorMessages.contains(emailValidationError));
        assertTrue(errorMessages.contains(genderValidationError));
    }
}
