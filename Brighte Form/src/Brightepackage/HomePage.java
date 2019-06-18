package Brightepackage;//created a package

import java.util.List;//importing the java utility
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;//importing the selenium jar files
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;//importing the assertion files for TestNG
import org.testng.annotations.Test;

		public class HomePage {

			public static void main(String[] args) throws InterruptedException {
				// TODO Auto-generated method stub
				
				//declaring the path for gecko driver
				System.setProperty("webdriver.gecko.driver","C:\\Users\\Pavit\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
				WebDriver driver = new FirefoxDriver(); //launch firefox Browser
				driver.get("https://portal.staging.brightelabs.com.au/pre-approvals/details");//getting the url
				
				driver.findElement(By.id("full-name")).sendKeys("Sameet");//inputting name in full field
				driver.findElement(By.id("mobile")).sendKeys("0400000000");//inputting mobile no. in mobile no. field
				
				WebElement text =driver.findElement(By.id("email"));//inputting the email id
				text.sendKeys("test@gmail.com");
				text.submit();// click on "Continue button"
				
				Thread.sleep(3000);//wait inorder to refresh elements on page 
				driver.findElement(By.id("base-net-income-amount")).sendKeys("9000");//inputting the value=9000 in Base net income field
				
				Thread.sleep(1000);//wait inorder to refresh elements on page 
				driver.findElement(By.className("select-dropdown")).click();//selecting drop down field	 and clicking on it			
				
				Thread.sleep(3000);
				//wait inorder to refresh elements on page 
				
				WebElement select = driver.findElement(By.cssSelector(".dropdown-content.select-dropdown.active"));
				Thread.sleep(1000);//wait inorder to refresh elements on page 
							
				List<WebElement> list = select.findElements(By.tagName("li"));
				list.get(2).click();						
				WebElement fullList = driver.findElement(By.id("pre-approval-how-much-can-i-borrow-form"));
				List<WebElement> listSecond = fullList.findElements(By.className("select-dropdown"));
				listSecond.get(2).click();//selecting drop down field and clicking on it	
							
							
				WebElement selectDepends = driver.findElement(By.cssSelector(".dropdown-content.select-dropdown.active"));
				Thread.sleep(1000);//wait inorder to refresh elements on page 
							
				List<WebElement> listDepend = selectDepends.findElements(By.tagName("li"));
				listDepend.get(3).click();
				
				WebElement formelement = driver.findElement(By.id("pre-approval-how-much-can-i-borrow-form"));
				
				//Initializing for loop in order to select "fortnightly" value in all the drop down list of income and expenses
				for (int x = 0; x < 6; x++) {			
				List<WebElement> formList = formelement.findElements(By.cssSelector(".form-group.input-field.number.required"));
				System.out.println(formList.isEmpty());
				System.out.println(formList.size());

				//exceptions used to exclude householdcredit card limit from selecting the dropdown list as no drop down is present with it
				try
				{
					WebElement formelemtestent = formList.get(x).findElement(By.className("select-dropdown"));
					 System.out.println("here" + x);
					
				if (formList.get(x).findElement(By.className("select-dropdown")).isDisplayed() == true) 
				 {
				 System.out.println("sateyaf" + x);
				 formList.get(x).findElement(By.className("select-dropdown")).click();
				 WebElement selectDependsx = driver.findElement(By.cssSelector(".dropdown-content.select-dropdown.active"));
				 Thread.sleep(1000);//wait inorder to refresh elements on page 
				 List<WebElement> listDependsx = selectDependsx.findElements(By.tagName("li"));
				 listDependsx.get(1).click();
				 System.out.println(x);
				 }
				} catch(Exception  e)
				
				{
		            continue;
		        }
				  }
				
				//input the values in income and expense fields
				driver.findElement(By.id("partners-base-net-income-amount")).sendKeys("7500");				
				driver.findElement(By.id("other-taxable-net-income-amount")).sendKeys("7500");
				driver.findElement(By.id("mortgage-repayment-amount")).sendKeys("1000");
				driver.findElement(By.id("other-loan-commitments-amount")).sendKeys("1500");
				driver.findElement(By.id("household-credit-card-limit-amount")).sendKeys("500");
				WebElement livingCost = driver.findElement(By.id("household-living-costs-amount"));
				livingCost.sendKeys("600");
				livingCost.submit();//clicking on Calculate limit button after entering all the values in income and expense fields
					
				//To check assert for pre approval amount and maximum repayment amount
				WebElement capacityAmount = driver.findElement(By.className("capacity"));
				WebElement repaymentAmount = driver.findElement(By.className("repayment-amount"));
				

		        Assert.assertTrue(capacityAmount.isDisplayed());
		        Assert.assertTrue(repaymentAmount.isDisplayed());
		        System.out.println("Assertion Passed successfully");
		         
		   
			driver.close();//closes the browser
				

			}


		

}
