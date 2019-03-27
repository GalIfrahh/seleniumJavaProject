package Infrastructure;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWrapper {

	RemoteWebDriver remoteWebDriver;
	
	public void init(String remoteUrl) throws MalformedURLException {
		
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		
		
		remoteWebDriver = new RemoteWebDriver(new URL(remoteUrl), capabilities);
	}
	
	
	public WebElement findElementBy(Locators locator, String value) {
		
		WebElement element = null;
		
		
		WebDriverWait driverWait = new WebDriverWait(remoteWebDriver, 15);
		
		
		switch (locator) {
		
		
		case XPATH:
			try {
				
				element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(value)));
	
				
			} catch (NullPointerException e){
				
				
				System.out.println("element not found - null");
			}
			break;
			
			
		case ID:
			
			try {
			
				
				element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id(value)));
			
				
			} catch (NullPointerException e){
			
				
				System.out.println("element not found - null");
			}
			break;
			
			
		case NAME:
			
			try {
			
			
				element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.name(value)));
			
				
			} catch (NullPointerException e){
			
				
				System.out.println("element not found - null");
			}
			break;
		
			
		default:
			
			
			System.out.println("the locator is wrong - please use the Locator enum");
		}
		
		
		return element;
	}
	
	
	public List<WebElement> findElementsBy(String value){
		
		WebDriverWait driverWait = new WebDriverWait(remoteWebDriver, 10);
		
		
		return driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(value)));
		
	}
	
	public void open(String url) {
		remoteWebDriver.get(url);
	}
	
	public void clearField(WebElement elementToClear) {
		
		elementToClear.clear();
		
		
		try {
			
			Thread.sleep(1000);
		
		
		} catch(InterruptedException e) {
			
		
			System.out.println(e.getMessage());
		}
	}
	
	public void close() {
		remoteWebDriver.close();
	}
	
	public void quit() {
		remoteWebDriver.quit();
	}
	
	public String getTitle() {
		
		return remoteWebDriver.getTitle(); 
	}
	
	public void hover(String elementToHoverValue) {
		
		Actions action = new Actions(remoteWebDriver);
		
		
		WebElement elementToHover = remoteWebDriver.findElementByXPath(elementToHoverValue);
		
		
		action.moveToElement(elementToHover).build().perform();
		
	}
	
	
	public void HoverAndClick(String elementToHoverValue, String elementToClickValue) {
	
		Actions action = new Actions(remoteWebDriver);
		
		
		WebElement elementToHover = remoteWebDriver.findElementByXPath(elementToHoverValue);

		
		WebElement elementToClick = remoteWebDriver.findElementByXPath(elementToClickValue);
		
		
		action.moveToElement(elementToHover).click(elementToClick).build().perform();

	}
	
	
	public void scrollToElement(String value) throws InterruptedException {
		
		WebElement element = remoteWebDriver.findElement(By.xpath(value));
		
		
		((JavascriptExecutor) remoteWebDriver).executeScript("arguments[0].scrollIntoView();", element);
		
	}
	
	
	public File takeScreenShot(String name) throws IOException {
		
		TakesScreenshot sc = (TakesScreenshot) remoteWebDriver;
		
		
		File source = sc.getScreenshotAs(OutputType.FILE);
		
		
		FileUtils.copyFile(source, new File("C:\\Users\\galif\\eclipse-workspace\\RedLionAutomation\\ScreenShots\\" + name + ".png"));
		

		return source;
		
	}
	
	
	public WebElement waitForElemToBeClickable(String value) {
		
		WebDriverWait wait = new WebDriverWait(remoteWebDriver, 10);
		
		
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(value)));
	} 
	
	
	public boolean waitForInvisibility(String value) {
		
		WebDriverWait wait = new WebDriverWait(remoteWebDriver, 10);
		
		
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(value)));
	} 
	
	
	public void MaximizeWIndow() {
		
		remoteWebDriver.manage().window().maximize();
	}
	
	
	
}
