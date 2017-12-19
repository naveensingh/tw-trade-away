package com.nyss.thoughtworks.tradeAway.utilities;

import org.junit.Assert;
import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class EncrytorTest {

    @Test
    public void verifyIFEncryptFunctionGivesSameStringforSameInputs() throws BadPaddingException, UnsupportedEncodingException, IllegalBlockSizeException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        String username = "SWETHA";
        String password = "Swe@123";
        Assert.assertEquals(Encryptor.encrypt(password,username),Encryptor.encrypt(password,username));
    }
    @Test
    public void verifyIFEncryptFunctionGivesDifferentStringforDifferentInputs() throws BadPaddingException, UnsupportedEncodingException, IllegalBlockSizeException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        String username = "SWETHA";
        String password = "Swe@123";
        String anotherPassword = "Swe@12";
        Assert.assertNotEquals(Encryptor.encrypt(password,username),Encryptor.encrypt(anotherPassword,username));
    }
}
