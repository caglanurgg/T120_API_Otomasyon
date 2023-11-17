package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C06_API_ResponseBodyTesti {

    /*
 https://jsonplaceholder.typicode.com/posts url’ine asagidaki body ile
 bir POST request gonderdigimizde
         {
         “title”:“API”,
         “body”:“API ogrenmek ne guzel”,
         “userId”:10,
         }
         donen Response’un,
         status code’unun 201,
         ve content type’inin application/json
         ve Response Body’sindeki,
          “title”’in “API” oldugunu
         “userId” degerinin 100’den kucuk oldugunu
         “body” nin “API” kelimesi icerdigini test edin.
  */
    @Test
    public void bodyTesti2(){

        // 1-Endpoint Hazırla
        String url="https://jsonplaceholder.typicode.com/posts";

        // 2-Soruda Expected Data verilseydi Expected Data bu adimda hazirlanacakti.

        // 3- Response Kaydet
        // Response response=given().when().get(url);---> Get Methoduyla boyle yapiyorduk

            /*
            {
            “title”:“API”,
            “body”:“API ogrenmek ne guzel”,
            “userId”:10,
            }
             */
        //*POST methodunda olmazsa olmaz seylerimizden biri Request body olmasadir.
        JSONObject reqBody=new JSONObject();
        reqBody.put("title","API");
        reqBody.put("body","API ogrenmek ne guzel");
        reqBody.put("userId",10);

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody.toString()).post(url);
//56.satir: body'nin icerisine reqBody'yi koyacagim ve bu bir obje oldugu icinde
//toString()'le gonderecegim.sonrada bunu url'ime post edecegim

        //sana JSON formatinda bir veri verdigim zaman
        //body'ye bunu at ve o url'e bunu post et. (53.satir - 56.satir)


        // 4-Assertion yap -response'u kontrol edelim-
        response.then().assertThat()
                .statusCode(201)
                .contentType("application/json")
                .body("title", equalTo("API"), //“title”’in “API” oldugunu
                        "body",containsString("API"), // “body” nin “API” kelimesi icerdigini test edin.
                        "userId",lessThan(100)); // “userId” degerinin 100’den kucuk oldugunu


    }
}
