package courier;

import io.qameta.allure.Step;
import lombok.Data;

@Data
public class CourierCredentials {
    private String login;
    private String password;

    public CourierCredentials(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Step("Авторизоваться в системе")
    public static CourierCredentials from(Courier courier) {
        return new CourierCredentials(courier.getLogin(), courier.getPassword());
    }
}
