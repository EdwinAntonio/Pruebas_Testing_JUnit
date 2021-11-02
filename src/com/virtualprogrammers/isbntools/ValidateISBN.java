package com.virtualprogrammers.isbntools;

public class ValidateISBN {
    public boolean checkAValidateISBN(String isbn) {
        if(isbn.length() < 10) throw new NumberFormatException("El ISBN debe de tener por lo menos 10 digitos");
        if(isbn.length() > 10) throw new NumberFormatException("El ISBN debe de tener por lo menos 10 digitos");
        int total = 0;
        for (int i=0; i<10; i++){
            if(!Character.isDigit(isbn.charAt(i))) {
                if(i == 9 && isbn.charAt(i) == 'X'){
                    //this is ok np! :D
                    total += 10;
                }else {
                    throw new NumberFormatException("El ISBN deben de ser puros numeros enteros");
                }
            }
            total += Character.getNumericValue(isbn.charAt(i)) * (10-i); /*Cuando realicemos valores con ASCII siempre
                                                                           tener en cuenta que hay que volver a
                                                                           convertirlos en numericos, por eso el
                                                                           Character.getNumberValue*/
        }
        if(total % 11 == 0){
            return true;
        }else {
            return false;
        }
    }
}
