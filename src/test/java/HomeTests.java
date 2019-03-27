

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.openqa.selenium.By;

import PageObjects.PageObjects.HomeScreen;
import ProjectUtils.SlackService;

public class HomeTests extends Basic {
	
	public String time_stamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	
	
    	@Test
	public void login(){
		
		HomeScreen.openRedLion();
			
		ConnectPage.clickOnHelloRewards_connectBtn();
				
		ConnectPage.enterEmail();
		
		ConnectPage.enterPassword();
		
		ConnectPage.clickOnSignIn();
		
		user_name = ConnectPage.getUserName();
		
		assertEquals(user_name, prop.getProperty('EMAIL'))
	}
	
	
	@Test
	public void redLionReservationFlow(){
	
		HomeScreen.openRedLion();
			
		ConnectPage.clickOnHelloRewards_connectBtn();
				
		ConnectPage.enterEmail();
		
		ConnectPage.enterPassword();
		
		ConnectPage.clickOnSignIn();
		
		HomePage.enterLocationName();
		
		HomePage.chooseFirstLocatio();
	
		HomePage.clickOnStartDateField();
		
		int active_date = HomeScreen.getSelectedStartDateIndex(HomeScreen.getDatePickerValues());
		
		HomePage.getDatePickerValues().get(active_date + 7).click();
		
		HomePage.getDatePickerValues().get(active_date + 8).click();
		
		HomePage.clickOnCheckAvailability();
		
		HomePage.clickOnQuickBook();
				
		String full_cancellation_text = OrderSummeryPage.getCencelationPolicyText();
		
		if(OrderSummeryPage.HasCancellation(full_cancellation_text)) {
						
			setTimeStemp(time_stamp);
			
			driverWrapper.takeScreenShot(time_stamp);
			
			// perform room reservation - needs real payments...
		
			confirmation_text = ConfirmationPage.getConfirmationText();
			
		assertEquals(confirmation_text, prop.getProperty('CONFIRMATION_TEXT'));
		}
				
	}
	
	
}
