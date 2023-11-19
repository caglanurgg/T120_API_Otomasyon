package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceBaseUrl {

    //Bu class altinda instance bir RequestSpesification objesi
    //olusturalim. (Bu objenin ismi genelde spec ile baslar)
    protected RequestSpecification specJsonPlace;

    @Before //*Before JUnit'den
    public void setUp(){

        specJsonPlace = new RequestSpecBuilder()
                .setBaseUri("https://jsonplaceholder.typicode.com")
                .build();
    }
}