import com.ispwproject.lacremepastel.controller.app.MakeOrderController;
import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderBean;
import org.junit.jupiter.api.Test;

public class TestMakeOrder {

    private final String CUSTOMER_NAME = "dummy";

    /** Testa che non venga accettato un utente senza sessione */
    @Test
    public void testCreateOrderNullSessionData() {
        MakeOrderController controller = new MakeOrderController();
        controller.createOrder(null, new OrderBean(CUSTOMER_NAME));
    }

}
