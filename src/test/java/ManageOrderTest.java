/*
import com.ispwproject.lacremepastel.controller.app.ManageOrderController;
import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderLineBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.SessionManager;
import com.ispwproject.lacremepastel.model.Order;
import com.ispwproject.lacremepastel.model.Session;
import com.ispwproject.lacremepastel.other.SupportedUserTypes;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public  class ManageOrderTest {

    @Test
      /*  public void testAcceptOrder() {

            // Creo una finta sessionBean
            SessionBean sessionBean = generateSession();

            // Creo una finta orderBean
            OrderBean orderBean = generateOrderBean();

            // Inizializzo l'orderBean
            orderBean.setIdOrder(1);
            orderBean.setCustomerName("FakeTino");

            // Creo l'istanza di ManageOrderController
            ManageOrderController manageOrderController = new ManageOrderController();

            // Provo ad accettare l'ordine
            manageOrderController.acceptOrder(sessionBean, orderBean);

            // Verifico se l'ordine è stato accettato o meno

            OrderBean orderBeanVerify = manageOrderController.getOrderById(sessionBean,orderBean);
            for(Order orderIndex : orderBeanVerify){
                OrderLineBean orderLineBean = orderBeanVerify.getAllOrder().get(orderIndex.getIdOrder());
                orderLineBean.
                assertTrue(order.isAccepted());
                assertFalse(order.isPending());
                assertFalse(order.isClosed());
            }

        }
    }
    // Fake SessionBean
    public void generateSession(){

        Session session = new Session(
                "FakeTino",
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
    private OrderBean generateOrderBean(){
        OrderBean orderBean = new OrderBean("FakeTino");
        return  orderBean;
    }
*/