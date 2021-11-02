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

}
