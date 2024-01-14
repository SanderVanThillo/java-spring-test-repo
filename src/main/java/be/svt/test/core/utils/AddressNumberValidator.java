package be.svt.test.core.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressNumberValidator {
    public static boolean isValidAddressNumber(String addressNumber) {
        Pattern pattern = Pattern.compile("[1-9]+[0-9]*[A-Z]?");
        Matcher matcher = pattern.matcher(addressNumber);
        return matcher.matches();
    }
}
