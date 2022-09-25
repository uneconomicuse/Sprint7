package order;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class OrderRandom {
    public static Order getDefaultOrderInfo(String[] colorScooter){

        return new Order(
                RandomStringUtils.randomAlphanumeric(10),// firstName
                RandomStringUtils.randomAlphanumeric(10),// lastName
                RandomStringUtils.randomAlphanumeric(10),// address
                RandomStringUtils.randomNumeric(1),// metroStation
                RandomStringUtils.randomNumeric(10),// phone
                new Random().nextInt(300),  // rentTime
                "2022-0"+RandomStringUtils.randomNumeric(1)+"-1"+RandomStringUtils.randomNumeric(1), // deliveryDate
                colorScooter,
                RandomStringUtils.randomAlphanumeric(30)// comment
        );
    }
}
