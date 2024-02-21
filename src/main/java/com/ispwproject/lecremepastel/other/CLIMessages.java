package com.ispwproject.lecremepastel.other;

public class CLIMessages {

    private CLIMessages(){}

    //*********** HOME SECTION **************//
    public static final String HOME_SECTION_CUSTOMER = """
            La Créme Pastel Home Page
            Select One of the following options:
            1 > New Order
            2 > Manage Orders
            3 > New Return Request
            4 > Show Notifies
            5 > Assistance
            0 > Logout\s""";

    public static final String HOME_SECTION_DIRECTOR = """
            La Créme Pastel Home Page
            Select One of the following options:
            1 > Show Customers
            2 > Manage Orders
            3 > Manage Products
            4 > Administrate Workers
            0 > Logout\s""";
    public static final String HOME_SECTION_WORKER = """
            La Créme Pastel Home Page
            Select One of the following options:
            1 > Show Production
            0 > Logout\s""";

    //*********** START SECTION **************//
    public static final String START_SECTION = """
            Welcome to La Créme Pastel!
            Select One of the following options:
            1 > Login
            2 > Register
            0 > Exit\s""";

    //*********** LOGIN SECTION **************//
    public static final String LOGIN_FAILED = "Login failed!\n";
    public static final String LOGIN_JSON_AUTH = "Insert Username > ";
    public static final String LOGIN_PASSWD = "Insert Password > ";
    public static final String LOGIN_SQL_AUTH = "Insert Username or Email > ";
    public static final String LOGIN_SUCCESSFUL = "Login successful!\n";


    //*********** MISCELLANEOUS **************//
    public static final String BYE_MESSAGE = "Exiting...";
    public static final String FEATURE_NOT_IMPLEMENTED="Feature Not Implemented Yet!";
    public static final String LOGOUT = "Logged Out!\n";
    public static final String PROMPT="> ";


    //*********** ERROR MESSAGES **************//
    public static final String EMPTY_INPUT = "Empty credentials are not accepted!";
    public static final String INVALID_INT = "Please, insert a valid number!";
}
