package test;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C05_Get_ResponseBodyTesti {

    //   https://jsonplaceholder.typicode.com/posts/44 url'ine
    //   bir GET request yolladigimizda donen Response'in
    //   status code'unun 200,
    //   ve content type'inin application/json; charset=utf-8,
    //   ve response body'sinde bulunan userId'nin 5,
    //   ve response body'sinde bulunan title'in "optio dolor molestias sit" oldugunu
    //   test edin.

    @Test
    public void bodyTesti(){

        //1- Endpoint Hazırla
        String url="https://jsonplaceholder.typicode.com/posts/44";

        // 2- Soruda verilmis ise Expected Body hazirla

        // 3- Dönecek Response kaydet
        Response response=given().when().get(url);
        // response.prettyPrint();

        // 4- Assertion Islemi
        response.then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("userId", Matchers.equalTo(5))
                .body("title",Matchers.equalTo("optio dolor molestias sit"));

        //Matchers classi herhangi bir body'nin icerisindeki
        //girdigimiz keyin karsiliginda ne yazdigini kontrol etmemizi saglar.
        // Expected ve Actual karsilastirmasi
    }
}
