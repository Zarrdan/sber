package FirstEx.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;


@Getter
public class NewUser {
    private String email;
    private String name;
    private String name1;
    private String hobby;
    private String surname1;
    private String fathername1;
    private String cat;
    private String dog;
    private String parrot;
    private String cavy;
    private String hamster;
    private String squirrel;
    private String phone;
    private String adres;
    private String gender;
    @JsonProperty("date_start")
    Date_start Date_startObject;
    @JsonProperty("date_updated")
    Date_updated Date_updatedObject;
    @JsonProperty("birthday")
    Birthday BirthdayObject;
    ArrayList<Object> role = new ArrayList<Object>();
    @JsonProperty("date_register")
    Date_register Date_registerObject;
    private String date;
    private String by_user;
    ArrayList<Object> companies = new ArrayList<Object>();
    ArrayList<Object> tasks = new ArrayList<Object>();

}
