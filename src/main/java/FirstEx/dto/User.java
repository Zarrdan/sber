package FirstEx.dto;

import java.util.ArrayList;

import FirstEx.specification.Specification;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {
    public String email;
    public String name;
    public ArrayList<String> companies;
    public ArrayList<Integer> tasks;
    public String hobby;
    public String inn;

    public User(ArrayList<String> companies, ArrayList<Integer> tasks,String hobby, String inn) {
        this.email = Specification.randomEmail();
        this.name = Specification.randomFirstName();
        this.companies = companies;
        this.tasks = tasks;
        this.hobby = hobby;
        this.inn = inn;
    }

//    public String adres;
//    public String name1;
//    public String surname1;
//    public String fathername1;
//    public String cat;
//    public String dog;
//    public String parrot;
//    public String cavy;
//    public String hamster;
//    public String squirrel;
//    public String phone;
//    public String gender;
//    public String birthday;
//    public String date_start;
}

