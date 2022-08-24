package rest;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;

public class DataProviderClass {

    @DataProvider(name = "test", parallel = true)
    Object[][] testCase() {
        ArrayList<String> company = new ArrayList<>();
        ArrayList<Integer> tasks = new ArrayList<>();
        company.add("10");
        company.add("41");
        tasks.add(12);

        return new Object[][]{
                {company, tasks, "Играть в мяч", "000000000127"},
                {company, tasks, "Играть в доту", "000000000128"},
                {company, tasks, "Лежать дома", "000000000129"},
        };
    }
}
