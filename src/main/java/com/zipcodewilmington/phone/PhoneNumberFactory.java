package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;
import com.zipcodewilmington.tools.RandomNumberFactory;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * Created by leon on 5/1/17.
 */
public final class PhoneNumberFactory {
    private static final Logger logger = Logger.getGlobal();

    private PhoneNumberFactory() {
        /** This constructor is private
         *  This class is uninstantiable */
    }

    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ //TODO - Implement logic
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount) {
        PhoneNumber[] randomNumberArray = new PhoneNumber[phoneNumberCount];

        for (int i = 0; i < phoneNumberCount; i++) {
            randomNumberArray[i] = createRandomPhoneNumber();
        }

        return randomNumberArray;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    public static PhoneNumber createRandomPhoneNumber() {
        Integer aCode = RandomNumberFactory.createInteger(100, 999);
        Integer cOCode = RandomNumberFactory.createInteger(100, 999);
        Integer pLCode = RandomNumberFactory.createInteger(1000, 9999);
        return createPhoneNumberSafely(aCode, cOCode, pLCode);
    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {
        String safeNumber = "";
        safeNumber =  "(" + areaCode + ")-" + centralOfficeCode + "-" + phoneLineCode;

        PhoneNumber safelyCreatedNumber;

        try {
            safelyCreatedNumber = createPhoneNumber(safeNumber);
        } catch (InvalidPhoneNumberFormatException whoops) {
            logger.log(Level.INFO, safeNumber + "is not a valid phone number.");
            return null;
        }

        return safelyCreatedNumber;
    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException {
        logger.log(Level.INFO,"Attempting to create a new PhoneNumber object with a value of " + phoneNumberString );
        PhoneNumber telephoneNumber = new PhoneNumber(phoneNumberString);
        return telephoneNumber;
    }

//    What is a variable
//    What is a method
//    What is a constructor? and how does it differ from a method?
//    What is a class and what is its relationship to `types`
//    createPhoneNumberSafely(2,null,8)

 }


