package test;

import baseUrl.JsonPlaceBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import testDatas.TestDataJSONPlace;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C21_PUT_DeSerialization extends JsonPlaceBaseUrl {
    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
    body’e sahip bir PUT request yolladigimizda donen response’in
    response body’sinin asagida verilen ile ayni oldugunu test ediniz

    Request Body
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }

    Expected Data :
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
     */
    @Test
    public void put01(){
        //1- EndPoint Hazırlama
        specJsonPlace.pathParams("pp1","posts","pp2",70);
        // pp1 degeri posts pp2 degeri 70

        TestDataJSONPlace testDataJSONPlace=new TestDataJSONPlace(); //obje olusturduk

        HashMap<String,Object> reqBody=testDataJSONPlace.requestBodyOlusturMAP();

        //2-Expected Data oluştur
        HashMap<String,Object> expData =testDataJSONPlace.requestBodyOlusturMAP();

        //3- Response kayıt
        Response response=given()
                .spec(specJsonPlace).contentType(ContentType.JSON)
                .when()
                .body(reqBody).put("/{pp1}/{pp2}");

        //* onceki classlarda .body(reqBody.toString()) diyorduk ama burada
        //* kullanmadik cunku eger herhangi bir obje olusturmamıssak
        //* bu classta 44.satirda zaten reqBody'yi bir Java objesi olarak
        //* olusturdugum icin Java reqBody'yi zaten taniyor bu yuzden
        //* toString yaparak herhangi bir seye cevirmeye ihtiyacım yok.

        //4- ASSERTION ISLEMI

        //*JSON olarak gelen veriyi JAVA diline cevirelim
        HashMap<String,Object> respMAP=response.as(HashMap.class);

        assertEquals(expData.get("title"),respMAP.get("title"));
        assertEquals(expData.get("body"),respMAP.get("body"));
        assertEquals(expData.get("userId"),respMAP.get("userId"));
        assertEquals(expData.get("id"),respMAP.get("id"));


    }
}