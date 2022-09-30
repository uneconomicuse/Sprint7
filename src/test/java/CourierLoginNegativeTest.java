import courier.Courier;
import courier.CourierClient;
import courier.CourierCredentials;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourierLoginNegativeTest {
    Courier courier;
    CourierClient courierClient;
    private int courierId;
    private String courierNewLogin = "tutututut@tutut.ru";
    private String courierNewPass = "1234567";

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
    @DisplayName("Авторизация курьера с некорректным логином")
    public void courierLoginIncorrectLogin() {
        boolean create = courierClient.create(courier)
                .extract().path("ok");

        String courierLogin = courier.getLogin();

        courier.setLogin(courierNewLogin);

        CourierCredentials creds = CourierCredentials.from(courier);

        String message = courierClient.loginFailed(creds)
                .statusCode(404)
                .extract().path("message");

        courier.setLogin(courierLogin);

        CourierCredentials creds1 = CourierCredentials.from(courier);

        courierId = courierClient.login(creds1)
                .extract().path("id");

        assertTrue(create);
        assertEquals("Учетная запись не найдена", message);
    }

    @Test
    @DisplayName("Авторизация курьера с некорректным паролем")
    public void courierLoginIncorrectPassword() {
        boolean create = courierClient.create(courier)
                .extract().path("ok");

        String courierPassword = courier.getPassword();

        courier.setPassword(courierNewPass);

        CourierCredentials creds = CourierCredentials.from(courier);

        String message = courierClient.loginFailed(creds)
                .statusCode(404)
                .extract().path("message");

        courier.setPassword(courierPassword);

        CourierCredentials creds1 = CourierCredentials.from(courier);

        courierId = courierClient.login(creds1)
                .extract().path("id");

        assertTrue(create);
        assertEquals("Учетная запись не найдена", message);
    }

    @Test
    @DisplayName("Авторизация курьера с пустым полем \"Логин\"")
    public void courierLoginEmptyLogin() {
        boolean create = courierClient.create(courier)
                .extract().path("ok");

        String courierLogin = courier.getLogin();

        courier.setLogin("");

        CourierCredentials creds = CourierCredentials.from(courier);

        String message = courierClient.loginFailed(creds)
                .statusCode(400)
                .extract().path("message");

        courier.setLogin(courierLogin);

        CourierCredentials creds1 = CourierCredentials.from(courier);

        courierId = courierClient.login(creds1)
                .extract().path("id");

        assertTrue(create);
        assertEquals("Недостаточно данных для входа", message);
    }

    @Test
    @DisplayName("Авторизация курьера с пустым полем \"Пароль\"")
    public void courierLoginEmptyPassword() {
        boolean create = courierClient.create(courier)
                .extract().path("ok");

        String courierPassword = courier.getPassword();

        courier.setPassword("");

        CourierCredentials creds = CourierCredentials.from(courier);

        String message = courierClient.loginFailed(creds)
                .statusCode(400)
                .extract().path("message");

        courier.setPassword(courierPassword);

        CourierCredentials creds1 = CourierCredentials.from(courier);

        courierId = courierClient.login(creds1)
                .extract().path("id");

        assertTrue(create);
        assertEquals("Недостаточно данных для входа", message);
    }
}
