package com.fca.calidad.unittest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
	
import io.github.bonigarcia.wdm.WebDriverManager;

public class testFacebook {
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  JavascriptExecutor js;
	@Before
	public void setUp() throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
	    driver = new ChromeDriver();
		baseUrl = "https://es-es.facebook.com/";
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    js = (JavascriptExecutor) driver;
	}
	private void pause(long mils) {
		try {
			Thread.sleep(mils);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	 @Test
	 @Ignore
	  public void testWrongPath() throws Exception {
	    driver.get("https://es-es.facebook.com/");
	    pause(5000);
	    WebElement email = driver.findElement(By.id("email"));
	    email.click();
	    pause(1000);
	    email.sendKeys("input");
	    pause(1000);
	    WebElement password = driver.findElement(By.id("pass"));
	    password.click();
	    pause(1000);
	    password.sendKeys("input2");
	    pause(1000);
	    password.sendKeys(Keys.ENTER);
	    pause(5000);
	    //WebElement error = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[2]/div[2]/form/div/div[1]/div[2]"));
	    assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/login/?privacy_mutation_token=eyJ0eXBlIjowLCJjcmVhdGlvbl90aW1lIjoxNjU2NzE2ODc5LCJjYWxsc2l0ZV9pZCI6MzgxMjI5MDc5NTc1OTQ2fQ%3D%3D");
	    TakeScreenshot("WrongPath.png");
	 }

	 @Test
	 public void testGoodPath() throws Exception {
		    driver.get("https://es-es.facebook.com/");
		    pause(5000);
		    WebElement email = driver.findElement(By.id("email"));
		    email.click();
		    pause(1000);
		    email.sendKeys("dibujitorihani@gmail.com");
		    pause(1000);
		    WebElement password = driver.findElement(By.id("pass"));
		    password.click();
		    pause(1000);
		    password.sendKeys("salazar19");
		    pause(1000);
		    password.sendKeys(Keys.ENTER);
		    pause(5000);
		    assertEquals(driver.getCurrentUrl(),"https://es-es.facebook.com/checkpoint/?next");
		    TakeScreenshot("GoodPathFacebook.jpg");
	 }
	 
	 public void TakeScreenshot(String name) {
		    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    try {
			    FileUtils.copyFile(scrFile, new File("/tmp/screenshots/", name));
		    }catch(IOException e) {
		    	e.printStackTrace();
		    }
		}
	 
	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      	}
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    	}
	  }
}

//ayudaa