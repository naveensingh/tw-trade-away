package com.nyss.thoughtworks.tradeAway.utilities;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class InputValidator {
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public boolean validateStringForAlphabetsOnly(String string) {
        return string != null && string.length() > 0 && string.matches("[a-zA-Z]+");
    }

    public boolean validateStringForAlphanumericCharacters(String string) {
        return string != null && string.length() > 0 && string.matches("[a-zA-Z0-9]+");
    }

    public boolean validateStringForEmail(String string) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(string);
        return matcher.find();
    }

    public boolean validateStringForNumbers(String string) {
        return string != null && string.length() > 0 && string.length() <= 10 && string.matches("[0-9]+");
    }
}
