package com.platzi.util;

public class PasswordUtil {
    public enum SecurityLevel {WEAK, MEDIUM, STRONG}

    public static SecurityLevel assessPassword(String password) {
        if (password.matches("^.{0,7}$")) return SecurityLevel.WEAK;// short length
        if (password.matches("\\d+$")) return SecurityLevel.WEAK; //only numbers
        if (password.matches("[a-zA-Z]+$")) return SecurityLevel.WEAK; //only letters
        if (password.matches("[a-zA-Z0-9]+$")) return SecurityLevel.MEDIUM; //only numbers and letters

        return SecurityLevel.STRONG;
    }

    /*
        REGEX INDEX
        ^                    start-of-string
        .                    represent any character (except new lines)
        []                   define a range of characters
        [0-9]                a digit must occur at least once
        [a-z]                a lower case letter must occur at least once
        [A-Z]                an upper case letter must occur at least once
        [@#$%^&+=]           a special character must occur at least once
        ^\S+$               no whitespace allowed in the entire string (in java string:   ^\S+$   )
        .{8,}                anything, at least eight places though
        +                    can be repeated several times
        $                    end of string
    */
}
