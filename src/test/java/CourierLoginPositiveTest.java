import courier.Courier;
import courier.CourierClient;
import courier.CourierCredentials;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class CourierLoginPositiveTest {
    Courier courier;
    CourierClient courierClient;
    private int courierId;

    @Before
    public void setup() {
        courier = Courier.getRandomCourier();
        courierClient = new CourierClient();
    }

    @After
    public void teardown() {
        courierClient.delete(courierId);
    }

    @Test
    @DisplayName("Авторизация курьера")
    public void courierLogin() {
        boolean login = courierClient.create(courier)
                .extract().path("ok");

        CourierCredentials creds = CourierCredentials.from(courier);

        courierId = courierClient.login(creds)
                .extract().path("id");

        assertTrue(login);
        assertNotEquals(0, courierId);
    }
}
