package com.mystore.pageobjects;

import com.mystore.actiondriver.ActionDriver;
import com.mystore.base.BaseClass;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import javax.swing.*;

public class LoginPage extends BaseClass {

    public LoginPage()
    {
        PageFactory.initElements(getDriver(),this);
    }
    @FindBy(xpath ="//*[@id=\"user-name\"]")
    WebElement usernametext;

    @FindBy(id ="password")
    WebElement passwordtext;

    @FindBy(id ="login-button")
    WebElement loginbutton;

    @FindBy(xpath = "//span[contains(text(),'Products')]")
    WebElement productstext;
    ActionDriver action = new ActionDriver();
   /* public  ProductsPage clickLogin()
    {

        action.click(driver,loginbutton);
        return new ProductsPage();
    }*/

    public Boolean validateproductpage()
    {
       //WebElement result = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
        return action.isDisplayed(getDriver(),productstext);
    }

    public void loginmethod(String username1, String password2) throws InterruptedException {
        Thread.sleep(5000);
        action.type(usernametext,username1);
        action.type(passwordtext,password2);
        action.click(getDriver(),loginbutton);
    }



}
