package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BaseTest;
import utils.*;


public class ApplicationPage extends BaseTest{
	
	private static By signUpBtn = By.id("signin2");
    private static By userNametxtBox = By.xpath("//input[@id='sign-username']");
    private static By passwordtxtBox = By.xpath("//input[@id='sign-password']");
    
    public ApplicationPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public static void userClickOnSignupAndEnterDeatils() {


    	
  
    }
    
    

}
