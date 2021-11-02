package com.virtualprogrammers.isbntools;

import org.junit.Test;
import static org.junit.Assert.*;

public class ExampleTest {

    @Test
    public void checkAValidateISBNTest(){
        //fail();
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkAValidateISBN("0140449116");
        assertTrue(result);
        result = validator.checkAValidateISBN("0140177396");
        assertTrue(result);
    }

    @Test
    public void checkAInvalidateISBNTest(){
        //ValidateISBN validator = new ValidateISBN();
        //boolean result = validator.checkAValidateISBN(9);
        assertFalse(new ValidateISBN().checkAValidateISBN("0140449117"));
    }

    @Test(expected = NumberFormatException.class)
    public void nineNumbersISBNAreNotAllowed(){
        new ValidateISBN().checkAValidateISBN("123456789");
    }

    @Test(expected = NumberFormatException.class)
    public void moreThanTenNumbersISBNAreNotAllowed(){
        new ValidateISBN().checkAValidateISBN("12345678901");
    }

    @Test(expected = NumberFormatException.class)
    public void noneNumericISBNAreNotAllowed(){
        new ValidateISBN().checkAValidateISBN("helloworld");
    }

    @Test
    public void isbnLastNumberIsAnX(){
        assertTrue(new ValidateISBN().checkAValidateISBN("012000030X"));
    }
}
