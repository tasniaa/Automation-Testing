package amujamuSiteTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataprovider {
    @DataProvider(name="inputs")
    public Object[] getData() {
        return new Object[][] {
                {"bmw", "m3"},
                {"audi", "a6"},
                {"benz", "c300"}
        };
    }

    @Test(dataProvider="inputs")
    public void testMethod1(String input1, String input2) {
        for (int i = 0; i < 2; i++) {
            System.out.println("Input 1: " + input1);

        }


    }
}
