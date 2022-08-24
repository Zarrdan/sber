package rest;

import FirstEx.Assertions.NewAsserts;
import FirstEx.dto.NewUser;
import FirstEx.dto.User;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.*;

import static io.restassured.RestAssured.given;
import static FirstEx.specification.Specification.*;

public class RestApiTest {

    @BeforeTest
    public void beforeTest() {
        installSpec(requestSpec(), 200);
    }


    @AfterTest
    public void afterTest() {
        deleteSpec();
    }

    @Test(dataProvider = "test", dataProviderClass = DataProviderClass.class)
    public void checkSucsessAuth(ArrayList<String> company, ArrayList<Integer> tasks, String hobby, String inn) {
        User newUserSent = new User(company, tasks, hobby, inn);
        NewUser newUserRecievd = given()
                .body(newUserSent)
                .when()
                .post()
                .then()
                .extract().as(NewUser.class);
        ArrayList<String> newUserCompany = getOnlyIdCompany(newUserRecievd);
        NewAsserts.assertEqualsIdCompany(company, newUserCompany, " id и количество компаний соответствует");
        NewAsserts.assertEqualsPost(newUserSent.getName(), newUserRecievd.getName(), "отправленное и полученное имя соответствует");
        NewAsserts.assertEqualsPost(newUserSent.getEmail(), newUserRecievd.getEmail(), "отправленное и полученное email соответствует");
        NewAsserts.assertEqualsPost(newUserSent.getHobby(), newUserRecievd.getHobby(), "отправленное и полученное hobby соответствует");
    }
}

