package test;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C07_TekrarlardanKurtulma {
    /*
    https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde donen Response’un,
            status code’unun 200,
            ve content type’inin application/json, ve response body’sindeki
            “firstname”in, “Eric”,
            ve “lastname”in, “Ericsson”,
            ve “totalprice”in, 888,
            ve “depositpaid”in, true,
	        ve “additionalneeds”in, “Breakfast” oldugunu test edin
     */

    @Test
    public void nonRepeat(){
        // 1- Endpoint hazırla
        String url="https://restful-booker.herokuapp.com/booking/10";

        // 2- Expected Body verilmediği için hazırlanmadı


        // 3- Response kaydet
        Response response=given().when().get(url);


        //4- Assertion yap

        response.then().assertThat().statusCode(200).contentType("application/json")
                .body("firstname", equalTo("Sally"),
                        "lastname", equalTo("Jackson"),
                        "totalprice", equalTo(604),
                        "depositpaid", equalTo(true),
                        "additionalneeds", equalTo("Breakfast"));

    }
}
