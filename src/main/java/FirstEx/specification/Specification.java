package FirstEx.specification;

import FirstEx.dto.NewUser;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Specification {

    public static String randomFirstName() {
        Faker faker = new Faker();
        return faker.name().firstName();
    }


    public static String randomEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public static RequestSpecification requestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri("http://users.bugred.ru/tasks/rest/createuser")
                .setContentType("application/json")
                .build();
    }

    public static ResponseSpecification responseSpec(Integer statusCode) {
        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .build();
    }


    @Step("Проверка на соответствие статус кода")
    public static void installSpec(RequestSpecification requestSpec, Integer statusCode) {
        RestAssured.requestSpecification = requestSpec;
        RestAssured.responseSpecification = responseSpec(statusCode);
    }

    public static void deleteSpec() {
        RestAssured.requestSpecification = null;
        RestAssured.responseSpecification = null;
    }

    public static ArrayList<String> getOnlyIdCompany(NewUser newUserRecievd) {
        ArrayList<String> newUserCompany = new ArrayList<>();

        for (int i = 0; i < newUserRecievd.getCompanies().size(); i++) {
            String text = newUserRecievd.getCompanies().get(i).toString().replaceAll("\\D", "");
            newUserCompany.add(text);
            Collections.sort(newUserCompany);
        }
        return newUserCompany;

    }


}
