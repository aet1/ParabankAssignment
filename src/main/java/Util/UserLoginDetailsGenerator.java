package Util;

import Pages.RegistrationPage;

public class UserLoginDetailsGenerator {
    private static String username;
    private static String password;

    public static String generateUsername() {
        RegistrationPage.generateRandomString(7);

        return username;
    }

    public static String setUsername(){
        return username;
    }

    public static String generatepassword() {
        RegistrationPage.generateRandomString(12);

        return password;
    }

    public static String setpassword(){
        return password;
    }


}
