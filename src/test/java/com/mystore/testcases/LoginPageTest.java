package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.zip.DataFormatException;

public class LoginPageTest extends BaseClass {
    LoginPage login;
    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke","Sanity"})
    public void Setup(String browser)
    {
        launchApp(browser);

    }
   @AfterClass(groups = {"Smoke","Sanity"})
    public void Teardown()
    {
        getDriver().quit();
    }
    @Test(dataProvider = "Credentials",dataProviderClass = DataProviders.class,groups = "Smoke")
    public void verifyuserlogin(String uname,String pwd) throws InterruptedException {
        Log.startTestCase("verifyuserlogin");
         login = new LoginPage();
         Log.info("User click on sign in button");
         //login.loginmethod(prop.getProperty("username"), prop.getProperty("password"));
        login.loginmethod(uname,pwd);
        boolean loginsucess = login.validateproductpage();
        Log.info("verify user able to login");
        Assert.assertTrue(loginsucess);
        Log.info("login sucess");
        Log.endTestCase("verifyuserlogin");
    }

    @Test(priority = 2,groups="Sanity" )
    public void validateproductpage()
    {
       Assert.assertTrue(login.validateproductpage());
    }


}
