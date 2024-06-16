import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import com.ispwproject.lacremepastel.controller.app.LoginController;
import com.ispwproject.lacremepastel.controller.app.ManageOrderController;
import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lacremepastel.model.Order;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class YourClassTest {

    private ManageOrderController manageOrderController;
    private SessionBean mockSessionBean;
    private OrderBean mockOrderBean;
    private LoginController  mockLoginController;

    @Before
    public void setUp() {
        manageOrderController = new ManageOrderController();
        mockSessionBean = mock(SessionBean.class);
        mockOrderBean = mock(OrderBean.class);
        mockLoginController = mock(LoginController.class);

    }

    @Test
    public void testAcceptOrder() {
        // Configura i mock
        when(mockOrderBean.getIdOrder()).thenReturn(1);
        when(mockOrderBean.getCustomerName()).thenReturn("Customer");

        // Esegui il metodo
        manageOrderController.acceptOrder(mockSessionBean, mockOrderBean);

        // Verifica che il metodo checkLogin sia stato chiamato una volta con il sessionBean corretto
        verify(mockLoginController, times(1)).checkLogin(mockSessionBean);

        // Crea un'istanza dell'ordine attesa
        Order expectedOrder = new Order(1, "Customer");
        expectedOrder.setPending(false);
        expectedOrder.setAccepted(true);
        expectedOrder.setClosed(false);

        // Verifica che il metodo manageOrder sia stato chiamato una volta con l'ordine corretto
        verify(manageOrderController, times(1)).acceptOrder(expectedOrder);
    }
}

