import com.ispwproject.lacremepastel.controller.app.MakeOrderController;
import com.ispwproject.lacremepastel.engineeringclasses.bean.*;
import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.SessionManager;
import com.ispwproject.lacremepastel.model.Session;
import com.ispwproject.lacremepastel.other.SupportedUserTypes;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class MakeOrderTest {

    private final String CUSTOMER_NAME = "dummy";

    /**
     * Verifica che un utente non loggato non possa effettuare ordini
     */
    @Test
    public void testCreateOrderNullSession() {

        MakeOrderController controller = new MakeOrderController();

        //Creazione di un ordine valido
        OrderBean orderBean = null;
        try {
            ProductBean productBean = new ProductBean(
                    0, "dummy", 1, "SAVORY", "dummy"
            );
            OrderLineBean orderLineBean = new OrderLineBean(productBean, 1);
            List<OrderLineBean> cart = new ArrayList<>();
            cart.add(orderLineBean);
            orderBean = new OrderBean(CUSTOMER_NAME, cart);
        }catch (Exception e){
            Assert.fail("Can't generate a valid order: "+e.getMessage());
        }

        //Test con sessione nulla e carrello valido
        boolean exceptionRaised = false;
        try{
            controller.createOrder(null, orderBean);
        }catch (InvalidParameterException ignored){
            exceptionRaised = true;
        }
        Assert.assertTrue(exceptionRaised);
    }

    /**
     * Verifica che non venga creato un ordine a partire da un carrello vuoto
     */
    @Test
    public void testCreateOrderInvalidOrder(){

        MakeOrderController controller = new MakeOrderController();
        SessionBean sessionBean = generateFakeSession();
        Assert.assertNotNull(sessionBean);

        //Creazione di un ordine con carrello vuoto
        OrderBean emptyCart = new OrderBean(CUSTOMER_NAME);

        //Test con sessione valida e carrello vuoto
        InvalidParameterException exception = Assert.assertThrows(
                InvalidParameterException.class,
                () -> controller.createOrder(sessionBean,emptyCart)
        );
        Assert.assertEquals("Cart is empty!", exception.getMessage());


    }

    /**
     * Verifica che non venga creato un ordine se il relativo bean è null
     */
    @Test
    public void testCreateOrderNullOrder(){

        MakeOrderController controller = new MakeOrderController();
        SessionBean sessionBean = generateFakeSession();
        Assert.assertNotNull(sessionBean);

        InvalidParameterException exception = Assert.assertThrows(
                InvalidParameterException.class,
                () ->   controller.createOrder(sessionBean,null)
        );
        Assert.assertEquals("OrderBean can't be null",exception.getMessage());
    }

    private SessionBean generateFakeSession(){
        //Creazione di una sessione finta (bypass del LoginController)
        Session session = new Session(
                CUSTOMER_NAME,
                SupportedUserTypes.CUSTOMER
        );
        SessionManager.getInstance().addSession(session);
        try {
            return new SessionBean(
                    session.getUuid(),
                    session.getUsertype().toString()
            );
        }catch(InvalidParameterException ignored){
            return null;
        }
    }

}
