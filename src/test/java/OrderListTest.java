import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import order.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class OrderListTest {
    private Order order;
    private PageInfo pageInfo;
    private OrderClient orderClient;

    @Before
    public void setup() {
        orderClient = new OrderClient();
    }

    @Test
    @DisplayName("Проверка списка заказов")
    public void getOrderListApiTest(){
        String[] colorScooter = new String[] {"GREY"};
        order = OrderRandom.getDefaultOrderInfo(colorScooter);
        ValidatableResponse response = orderClient.create(order);
        response = orderClient.create(order);

        ValidatableResponse responseOrderList = orderClient.getOrderList();

        OrderList ordersList = responseOrderList.extract().body().as(OrderList.class);
        List<Order> orders = ordersList.getCreatedOrders();
        int quantityOrders = orders.size();

        assertEquals(true, quantityOrders >= 2);
    }
}
