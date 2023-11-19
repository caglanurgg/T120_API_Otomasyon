package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HerOkuAppBaseURL {
    //Bu class altinda instance bir RequestSpesification objesi
    //olusturalim. (Bu objenin ismi genelde spec ile baslar)

    protected RequestSpecification specHerOkuApp;

    @Before //*Before JUnit'den
    public void setUP(){
        specHerOkuApp= new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();


    }

}