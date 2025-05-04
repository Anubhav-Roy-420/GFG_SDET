package TestNGAnnotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class HooksExample1 {

    @BeforeSuite
    public static void BS()
    {
        System.out.println("Before Suite II");
    }

    @Test
    public static void Meth()
    {
        System.out.println("2nd class Method");
    }

    @AfterClass
    public static void AC(){
        System.out.println("AC II");
    }
}
