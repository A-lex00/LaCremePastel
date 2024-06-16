import com.ispwproject.lacremepastel.controller.app.LoginController;
import com.ispwproject.lacremepastel.engineeringclasses.bean.RegisterBean;
import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;
import com.ispwproject.lacremepastel.engineeringclasses.exception.UserAlreadyExistentException;
import org.junit.Assert;
import org.junit.Test;

public class UserRegistrationTest {

    /**
     * Verifica che venga sollevata l'eccezione adeguata se si inseriscono credenziali esistenti
     */
    @Test
    public void testRegistrationWithExistingCredentials(){

        RegisterBean registerBean = new RegisterBean(
                "Dummy","12345678910","1234",
                "Dummy","Dummy", "si@si.it",
                "DIRECTOR"
        );

        LoginController loginController = new LoginController();
        Assert.assertThrows(
            UserAlreadyExistentException.class,
            () -> loginController.register(registerBean)
        );
    }

    /**
     * Verifica che non venga ammessa la registrazione dell'utente con dati non validi
     */
    @Test
    public void testRegistrationWithInvalidBean(){
        String invalidCF = "aosjfabo";
        int res = 0;
        try {
            new RegisterBean(
                    "Dummy", invalidCF, "1234",
                    "Dummy", "Dummy", "si@si.it",
                    "DIRECTOR"
            );
        }catch (InvalidParameterException ignored){
            res = 1;
        }

        Assert.assertEquals(1, res);
    }

    /**
     * Verifica che non venga ammessa la registrazione dell'utente se non vengono forniti dati
     */
    @Test
    public void testRegistrationWithNullBean() throws UserAlreadyExistentException {
        LoginController loginController = new LoginController();
        Assert.assertFalse(loginController.register(null));
    }

}


