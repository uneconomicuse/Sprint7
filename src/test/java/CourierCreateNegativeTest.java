import courier.Courier;
import courier.CourierClient;
import courier.CourierCredentials;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourierCreateNegativeTest {

    Courier courier;
    CourierClient courierClient;
    private int courierId;

    @Before
    public void setup() {
        courier = Courier.getRandomCourier();
        courierClient = new CourierClient();
    }

    @Test
    @DisplayName("Создание курьера с повторяющимся логином")
    public void courierDuplicateCreateTest() {
        boolean createCourier = courierClient.create(courier)
                .extract().path("ok");

        String message = courierClient.createFailed(courier)
                .statusCode(409)
                .extract().path("message");

        CourierCredentials creds = CourierCredentials.from(courier);

        courierId = courierClient.login(creds)
                .extract().path("id");

        assertTrue(createCourier);
        assertEquals("Этот логин уже используется. Попробуйте другой.", message);

        courierClient.delete(courierId);
    }

    @Test
    @DisplayName("Создание курьера с повторяющимся паролем")
    public void courierCreateWithoutPasswordTest() {
        Courier courier = Courier.getWithoutPassword();

        String message = courierClient.createFailed(courier)
                .statusCode(400)
                .extract().path("message");

        assertEquals("Недостаточно данных для создания учетной записи", message);
    }

    @Test
    @DisplayName("Создание курьера без логина")
    public void courierCreateWithoutLoginTest() {
        Courier courier = Courier.getWithoutLogin();

        String message = courierClient.createFailed(courier)
                .statusCode(400)
                .extract().path("message");

        assertEquals("Недостаточно данных для создания учетной записи", message);
    }

}
