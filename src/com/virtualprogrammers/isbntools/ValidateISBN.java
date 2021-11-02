package com.virtualprogrammers.isbntools;

public class ValidateISBN {
    public boolean checkAValidateISBN(String isbn) {
        if(isbn.length() == 13) {
            return isbn13Digits(isbn);
        }else {
            return isbn10Digits(isbn);
        }
    }

    private boolean isbn10Digits(String isbn) {
        //Codigo para un ISBN con 10 Digitos
        if (isbn.length() < 10) throw new NumberFormatException("El ISBN debe de tener por lo menos 10 digitos");
        if (isbn.length() > 10) throw new NumberFormatException("El ISBN debe de tener por lo menos 10 digitos");
        int total = 0;
        for (int i = 0; i < 10; i++) {
            if (!Character.isDigit(isbn.charAt(i))) {
                if (i == 9 && isbn.charAt(i) == 'X') {
                    //this is ok np! :D
                    total += 10;
                } else {
                    throw new NumberFormatException("El ISBN deben de ser puros numeros enteros");
                }
            }
            total += Character.getNumericValue(isbn.charAt(i)) * (10 - i); /*Cuando realicemos valores con ASCII siempre
                                                                       tener en cuenta que hay que volver a
                                                                       convertirlos en numericos, por eso el
                                                                       Character.getNumberValue*/
        }

        //Codigo usado para la validacion de un codigo ISBN de 10 Digts (Buscado en GOOGLE)
        if (total % 11 == 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isbn13Digits(String isbn) {
        //Codigo par aun ISB con 13 digitos
        int total = 0;

        for (int i=0;i<13;i++){
            if(i%2 == 0){
                total += Character.getNumericValue(isbn.charAt(i));
            }else {
                total += Character.getNumericValue(isbn.charAt(i)) * 3;
            }
        }

        //Codigo usado para la validacion de un codigo ISBN de 13 Digts (Buscado en GOOGLE)
        if (total % 10 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
