package _SecnarioOutline._SecnarioOutline;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.DataTable;
import cucumber.api.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Data_Table {
	WebDriver driver;

@Given("^url \"([^\"]*)\"$")
public void url(String arg1) throws Throwable {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(arg1);
   
}
String firstName,lastName,email,phoneNumber,password,newsLetter;
@Given("^registration details$")
public void registration_details(DataTable table) throws Throwable {
	List<List<String>> input=table.raw();
	System.out.println("FirstName :"+input.get(0).get(0));
	System.out.println("Last Name :" +input.get(0).get(1));
	System.out.println("email :"+input.get(0).get(2));
	System.out.println("phone number :"+input.get(0).get(3));
	System.out.println("passsword :"+ input.get(0).get(4));
	System.out.println("Newsletter subscription :" + input.get(0).get(1));
	
	firstName=input.get(0).get(0);
	lastName=input.get(0).get(1);
	email=input.get(0).get(2);
	phoneNumber=input.get(0).get(3);
	password=input.get(0).get(4);
	newsLetter=input.get(0).get(5);
	
}

@When("^I click on submit$")
public void i_click_on_submit() throws Throwable {
	driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(firstName);
	driver.findElement(By.id("input-lastname")).sendKeys(lastName);
	driver.findElement(By.cssSelector("#input-email")).sendKeys(email);
	driver.findElement(By.cssSelector("input[type='tel']")).sendKeys(phoneNumber);
	driver.findElement(By.id("input-password")).sendKeys(password);
   driver.findElement(By.cssSelector("#input-confirm")).sendKeys(password);
   if(newsLetter.equalsIgnoreCase("Yes"))
		   {
	   driver.findElement(By.xpath("//input[@value='1']")).click();
   }else {
	   driver.findElement(By.xpath("//input[@type='radio' and @value='0']")).click();
   }
   driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
   driver.findElement(By.xpath("//input[@type='checkbox']")).click();
}

@Then("^I validate the outcomes$")
public void i_validate_the_outcomes() throws Throwable {
   System.out.println("form is filled succesfully");
}

}
