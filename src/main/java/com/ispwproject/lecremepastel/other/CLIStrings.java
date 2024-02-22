package com.ispwproject.lecremepastel.other;

public class CLIStrings {

    private CLIStrings(){}

    //*********** HOME SECTION **************//
    public static final String HOME_SECTION_CUSTOMER = """
            Home Page La Créme Pastel
            Seleziona una delle seguenti opzioni:
            1 > Nuovo Ordine
            2 > Gestisci Ordini
            3 > Nuova Richiesta di Reso
            4 > Mostra Notifiche
            5 > Assistenza
            0 > Esci\s""";

    public static final String HOME_SECTION_DIRECTOR = """
            Home Page La Créme Pastel
            Selezionare una delle seguenti opzioni:
            1 > Mostra Clienti
            2 > Gestisci Ordini
            3 > Gestisci Prodotti
            4 > Amministra Dipendenti
            0 > Esci\s""";
    public static final String HOME_SECTION_WORKER = """
            Home Page La Créme Pastel
            Selezionare una delle seguenti opzioni:
            1 > Mostra Produzione
            0 > Esci\s""";

    //*********** START SECTION **************//
    public static final String START_SECTION = """
            Benvenuto in Créme Pastel!
            Selezionare una delle seguenti opzioni:
            1 > Accedi
            2 > Registrati
            0 > Chiudi\s""";

    //*********** LOGIN SECTION **************//
    public static final String LOGIN_FAILED = "Accesso fallito!\n";
    public static final String LOGIN_JSON_AUTH = "Inserire il Nome Utente > ";
    public static final String LOGIN_PASSWD = "Inserire la Password > ";
    public static final String LOGIN_SQL_AUTH = "Inserire Nome Utente o Email > ";
    public static final String LOGIN_SUCCESSFUL = "Accesso Riuscito!\n";

    //*********** REGISTER SECTION **************//
    public static final String CHOOSE_USER_TYPE = """
            Selezionare la tipologia di utenza:
            1 > Direttore
            2 > Dipendente
            3 > Cliente\s""";

    public static final String FIRSTNAME_PROMPT = "Inserire il Nome > ";
    public static final String LASTNAME_PROMPT = "Inserire il Cognome > ";
    public static final String USERNAME_PROMPT = "Inserire il Nome Utente che si vuole utilizzare > ";
    public static final String EMAIL_PROMPT = "Inserire l'indirizzo Email > ";
    public static final String PASSWD_PROMPT = "Inserire la Password > ";
    public static final String ROLE_PROMPT = "Inserire la propria Specializzazione > ";
    public static final String BILLING_ADDRESS_PROMPT = "Inserire l'Indirizzo di Fatturazione > ";
    public static final String CONFIRM_DATA = "I dati inseriti sono corretti? [s/N] > ";
    public static final String REGISTRATION_FAILED = "Registrazione Fallita!";
    public static final String REGISTRATION_SUCCESS = "Registrazione Completata!";

    //*********** MISCELLANEOUS **************//
    public static final String BYE_MESSAGE = "Chiusura...";
    public static final String FEATURE_NOT_IMPLEMENTED="Funzionalità in via di sviluppo!";
    public static final String LOGOUT = "Uscito!\n";
    public static final String PROMPT="> ";


    //*********** ERROR MESSAGES **************//
    public static final String EMPTY_INPUT = "Non sono ammesse credenziali vuote!";
    public static final String INVALID_INT = "Inserire un numero valido!";
}
