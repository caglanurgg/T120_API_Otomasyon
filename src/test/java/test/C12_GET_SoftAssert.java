package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C12_GET_SoftAssert {
      /*
     http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
    gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.

        * bir Response Body gordugumuz zaman bu Expected Body demektir.
        Response Body - Expected Body
        {
        "status":"success",
        "data":{
                "id":3,
                "employee_name":"Ashton Cox",
                "employee_salary":86000,
                "employee_age":66,
                "profile_image":""
                },
        "message":"Successfully! Record has been fetched."
        }
     */

    //* get methodu oldugu icin burada bir request body'im yok.

    @Test
    public void get01(){
        //1- Endpoint Hazirlama
        String url="http://dummy.restapiexample.com/api/v1/employee/3";

        // 2- Expected Body yani Expected Data'nin hazirlanmasi
        JSONObject data=new JSONObject();
        data.put("id",3);
        data.put( "employee_name","Ashton Cox");
        data.put("employee_salary",86000);
        data.put("employee_age",66);
        data.put("profile_image","");

        JSONObject expData=new JSONObject();
        expData.put("status","success");
        expData.put("data",data);
        expData.put("message","Successfully! Record has been fetched.");

        //3- Response Kaydetmek
        Response response=given().when().get(url);

        //4- Assertion İslemi
        JsonPath resJP=response.jsonPath();

        SoftAssert softAssert=new SoftAssert(); // obje olusturduk

        softAssert.assertEquals(resJP.get("status"),expData.get("status"));
        softAssert.assertEquals(resJP.get("data.id"),expData.getJSONObject("data").get("id"));
        softAssert.assertEquals(resJP.get("data.employee_name"),expData.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(resJP.get("data.employee_salary"),expData.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(resJP.get("data.employee_age"),expData.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(resJP.get("data.profile_image"),expData.getJSONObject("data").get("profile_image"));
        softAssert.assertEquals(resJP.get("message"),expData.get("message"));

        softAssert.assertAll();



    }
}
