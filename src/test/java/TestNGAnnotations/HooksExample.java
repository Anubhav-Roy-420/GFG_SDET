package TestNGAnnotations;

import org.testng.annotations.*;

public class HooksExample {

    @BeforeSuite
        public static void BSuite(){
        System.out.println("Before Suite");
    }

    @BeforeTest
    public static void BT(){
        System.out.println("Before Test");
    }

    @AfterSuite
    public static void ASuite(){
        System.out.println("After Suite");
    }

    @BeforeClass
    public static void BClass(){
        System.out.println("Before Class");
    }

    @Test
    public static void testMeth(){
        System.out.println("Test Method");
    }

    @Test
    public static void testMeth2(){
        System.out.println("Test Method 2");
    }

    @AfterMethod
    public static void AM(){
        System.out.println("After Method");
    }

    @AfterClass
    public static void AC(){
        System.out.println("AC I");
    }
}
