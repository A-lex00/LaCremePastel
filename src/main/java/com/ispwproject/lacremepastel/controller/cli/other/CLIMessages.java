package com.ispwproject.lacremepastel.controller.cli.other;

public class CLIMessages {

    //------------------- Miscellaneous --------------------//
    public static String promptExpr = "> ";

    public static String chooseExpr = "Please choose one of the following options:\n";

    //------------------- Landing Page --------------------//
    public static String welcome = "Welcome to La Créme Pastel!\n";

    public static String landingMenu = """
            Please choose one of the following options:
            1) Login
            2) Register""";

    //------------------- Login & Register Page --------------------//
    public static String authPrompt = "Insert Username or Email\n";

    public static String passwordPrompt = "Insert Password\n";

    public static String loginFailed = "Wrong Credentials\n";

    public static String loginSuccess = "Login Successful\n";

    //------------------- Register Page --------------------//
    public static String userTypePrompt = """
            Please choose the user type:
            1) Director
            2) Worker
            3) Customer""";

    public static String cfPivaPrompt = "Insert your CF or P.IVA\n";

    public static String firstnamePrompt = "Insert first name\n";

    public static String lastnamePrompt = "Insert last name\n";

    public static String emailPrompt = "Insert email\n";

    public static String billingAddressPrompt = "Insert your billing address\n";

    public static String rolePrompt = "Insert your role\n";


    //------------------- HomePage --------------------//
    public static String homeMenu = """
            Please choose one of the following options:
            1) New Order
            2) Show Your Orders
            0) Log Out""";
}
