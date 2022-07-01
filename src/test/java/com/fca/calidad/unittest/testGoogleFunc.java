package com.fca.calidad.unittest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
	//
import io.github.bonigarcia.wdm.WebDriverManager;

public class testGoogleFunc {
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  JavascriptExecutor js;
	@Before
	public void setUp() throws Exception {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		baseUrl = "https://www.google.com/";
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
	  public void testUntitledTestCase() throws Exception {
	    driver.get("https://www.google.com.mx/");

	    driver.findElement(By.name("q")).clear();

	    driver.findElement(By.name("q")).sendKeys("gatitos");
	    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	    driver.findElement(By.linkText("Imágenes")).click();
	    driver.findElement(By.xpath("//img[@alt='Todo lo que tienes que saber de los gatitos bebés | Purina®']")).click();
	    pause(5000);
	    driver.findElement(By.xpath("//div[@id='Sva75c']/div/div/div[3]/div[2]/c-wiz/div/div/div[3]/div/a/h1")).click();
	    pause(5000);
	    driver.get("https://www.purina-latam.com/mx/purina/nota/gatos/gatos-en-adopcion-que-saber-de-los-gatitos-bebes");
	    pause(5000);
	    assertEquals("Todo lo que tienes que saber de los gatitos bebés | Purina®", driver.getTitle());
	    TakeScreenshot("testGoogleFunc.png");
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
	  public void TakeScreenshot(String name) {
		    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    try {
			    FileUtils.copyFile(scrFile, new File("tmp/screenshots/", name));
		    }catch(IOException e) {
		    	e.printStackTrace();
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


