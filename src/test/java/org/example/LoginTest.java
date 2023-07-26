package org.example;
import mockit.Mocked;
import mockit.Tested;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
    @Test(priority = 2,description = "login details")
        // @BeforeClass
    void loginUpdate(){
        System.out.println("successfully logged in");
    }
    @Test(priority = 1,description = "logout details")
    void logoutUpdate(){
        System.out.println("logged out successfully");
    }
    @Test
    void addNum(){
        int actualSum=2+3;
        int expectedSum=5;
        Assert.assertEquals(actualSum,expectedSum,"method gives correct output");
    }
    @Test void testSub(){
        Calculator calculate=new Calculator();
        int actual=calculate.addition(2,3);
        int expected = 5;
        Assert.assertEquals(actual,expected);
        Assert.assertTrue(actual==expected);
    }
    @Tested Calculator calculator;
    @Test void testMultiply(){
        int actual=calculator.multiply(2,3);
        Assert.assertEquals(actual,6);
    }


}