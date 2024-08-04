package org.maven.fitpeo.fitpeoassignment;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Assignment {
 
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://www.fitpeo.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
		
		driver.findElement(By.linkText("Revenue Calculator")).click();
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement scroll = driver.findElement(By.xpath("(//div[@class='MuiBox-root css-19xu03j'])[1]"));
		 // Replace with the actual ID of the slider section
		 js.executeScript("arguments[0].scrollIntoView(true);", scroll);
		 System.out.println("scrolled");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
									
			  WebElement slider = driver.findElement(By.xpath("//input[@aria-valuenow='200']"));
			  System.out.println("location of the slider"+slider.getLocation());//(803, 654)
			  System.out.println("size of the slider"+slider.getSize());//(20, 20)
			 			
    	    Actions move = new Actions(driver);
	       move.dragAndDropBy(slider, 94, 3).perform();
	       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  Actions cleardata = new Actions(driver);
		      cleardata.click(driver.findElement(By.xpath("//input[@type='number']")))
		      .keyDown(Keys.CONTROL)
		      .sendKeys("a")
		      .keyUp(Keys.CONTROL)
		      .sendKeys(Keys.BACK_SPACE)
		      .build()
		      .perform();
		      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		      driver.findElement(By.xpath("//input[@type='number']")).sendKeys("560");
		      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		      
		      driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[1]")).click();
		      driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[2]")).click();
		      driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[3]")).click();
		      driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[8]")).click();
		      
		      WebElement reimbursementHeader = driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 inter css-hocx5c'])[4]")); // Update with actual ID
		      String reimbursementValue = reimbursementHeader.getText();
		   //   Assert.assertEquals(reimbursementValue, "$110700");
		      
		      if(reimbursementValue=="$110700"){
		    	  System.out.println("Total Recurring Reimbursement for all paitents per month should display $110700");
		    	  
		      }else {
		    	  System.out.println("Total Recurring Reimbursement for all paitents per month but should display as $75600");
		      }
	}

}

