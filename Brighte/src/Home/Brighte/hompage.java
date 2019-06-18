package Home.Brighte;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


import org.testng.Assert;
import org.testng.annotations.Test;
 

public class hompage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Pavit\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver(); //launch firefox Browser
		driver.get("https://portal.staging.brightelabs.com.au/pre-approvals/details");
		
		driver.findElement(By.id("full-name")).sendKeys("Sameet");
		driver.findElement(By.id("mobile")).sendKeys("0400000000");
		
		WebElement text =driver.findElement(By.id("email"));
		text.sendKeys("test@gmail.com");
		text.submit();
		
		Thread.sleep(3000);
		driver.findElement(By.id("base-net-income-amount")).sendKeys("9000");
		
		Thread.sleep(1000);
		driver.findElement(By.className("select-dropdown")).click();
		
		
		Thread.sleep(3000);

		
		WebElement select = driver.findElement(By.cssSelector(".dropdown-content.select-dropdown.active"));
		Thread.sleep(1000);
					
		List<WebElement> list = select.findElements(By.tagName("li"));
		list.get(2).click();
		
					
		WebElement fullList = driver.findElement(By.id("pre-approval-how-much-can-i-borrow-form"));
		List<WebElement> listSecond = fullList.findElements(By.className("select-dropdown"));
		listSecond.get(2).click();
					
					
		WebElement selectDepends = driver.findElement(By.cssSelector(".dropdown-content.select-dropdown.active"));
		Thread.sleep(1000);
					
		List<WebElement> listDepend = selectDepends.findElements(By.tagName("li"));
		listDepend.get(3).click();
		
		WebElement formelement = driver.findElement(By.id("pre-approval-how-much-can-i-borrow-form"));
		
			
		for (int x = 0; x < 6; x++) {			
		List<WebElement> formList = formelement.findElements(By.cssSelector(".form-group.input-field.number.required"));
		System.out.println(formList.isEmpty());
		System.out.println(formList.size());

		try {
			WebElement formelemtestent = formList.get(x).findElement(By.className("select-dropdown"));
			 System.out.println("here" + x);
			
		if (formList.get(x).findElement(By.className("select-dropdown")).isDisplayed() == true) {
		
			 System.out.println("sateyaf" + x);
			 
		formList.get(x).findElement(By.className("select-dropdown")).click();
		
		
		WebElement selectDependsx = driver.findElement(By.cssSelector(".dropdown-content.select-dropdown.active"));
		Thread.sleep(1000);
					
		List<WebElement> listDependsx = selectDependsx.findElements(By.tagName("li"));
		listDependsx.get(1).click();
		System.out.println(x);
		
		 }
		} catch(Exception  e){
            continue;
        }
		}
		
		
		driver.findElement(By.id("partners-base-net-income-amount")).sendKeys("7500");
		
		
		
		driver.findElement(By.id("other-taxable-net-income-amount")).sendKeys("7500");
		driver.findElement(By.id("mortgage-repayment-amount")).sendKeys("1000");
		driver.findElement(By.id("other-loan-commitments-amount")).sendKeys("1500");
		driver.findElement(By.id("household-credit-card-limit-amount")).sendKeys("500");
	

		WebElement livingCost = driver.findElement(By.id("household-living-costs-amount"));
		livingCost.sendKeys("600");
		livingCost.submit();
			
		
		WebElement capacityAmount = driver.findElement(By.className("capacity"));
		WebElement repaymentAmount = driver.findElement(By.className("repayment-amount"));
		

        Assert.assertTrue(capacityAmount.isDisplayed());
        Assert.assertTrue(repaymentAmount.isDisplayed());
        System.out.println("Assertion Passed successfully");
         
   
	driver.close();//closes the browser
		

	}


}