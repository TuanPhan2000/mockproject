package util;

import java.util.regex.Matcher;

public class Validator {

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = Constain.VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
    public static boolean validatePhoneNumber(String phoneNumberStr) {
        Matcher matcher = Constain.VALID_PHONE_NUMBER.matcher(phoneNumberStr);
        return matcher.find();
    }
}
