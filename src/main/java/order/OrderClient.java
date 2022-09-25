package order;

import courier.BaseClient;
import io.restassured.response.ValidatableResponse;

public class OrderClient extends BaseClient {

    private final String ORDER = "/orders";

    public ValidatableResponse create(Order order) {
        return getSpec()
                .body(order)
                .when()
                .post(ORDER)
                .then().log().all();
    }

    public ValidatableResponse getOrderList(){
        return getSpec()
                .when()
                .get(ORDER)
                .then();
    }
}
