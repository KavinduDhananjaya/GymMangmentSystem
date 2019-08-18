package lk.ijse.gymsystem.common;

import java.util.regex.Pattern;

public class Validate {
    public static boolean checkValidation(String regEx,String field){
        boolean matches = Pattern.compile(regEx).matcher(field).matches();
        return matches;
    }
}
