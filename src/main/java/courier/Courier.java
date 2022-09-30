package courier;

import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;

public class Courier {
    private String login;
    private String password;
    private String firstName;

    public Courier(String login, String password, String firstName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }

    @Step("Создать курьера со случайными значениями")
    public static Courier getRandomCourier() {
        return new Courier (
                RandomStringUtils.randomAlphanumeric(10) + "@example.com",
                "123456",
                RandomStringUtils.randomAlphabetic(10)
        );
    }

    @Step("Создать курьера без пароля")
    public static Courier getWithoutPassword() {
        return new Courier(
                RandomStringUtils.randomAlphanumeric(10) + "@example.com",
                "",
                RandomStringUtils.randomAlphabetic(10)
        );
    }

    @Step("Создать курьера без логина")
    public static Courier getWithoutLogin() {
        return new Courier(
                "",
                RandomStringUtils.randomAlphanumeric(10),
                RandomStringUtils.randomAlphabetic(10)
        );
    }

    @Step("Получить логин курьера")
    public String getLogin() {
        return login;
    }

    @Step("Задать новый логин курьера")
    public void setLogin(String login) {
        this.login = login;
    }

    @Step("Получить пароль курьера")
    public String getPassword() {
        return password;
    }

    @Step("Задать новый пароль курьера")
    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
