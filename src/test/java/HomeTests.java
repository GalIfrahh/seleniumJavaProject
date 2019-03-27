

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
	public void redLionReservation() throws Exception {
	
		HomeScreen.openRedLion();
		System.out.println("opened!!!!");		
		HomeScreen.clickOnHelloRewards();
				
		HomeScreen.enterEmail();
		
		HomeScreen.enterPassword();
		
		HomeScreen.clickOnSignIn();
		
		HomeScreen.enterLocationName();
		
		HomeScreen.chooseFirstLocatio();
	
		HomeScreen.clickOnStartDateField();
		
		int active_date = HomeScreen.getSelectedStartDateIndex(HomeScreen.getDatePickerValues());
		
		HomeScreen.getDatePickerValues().get(active_date + 7).click();
		
		HomeScreen.getDatePickerValues().get(active_date + 8).click();
		
		HomeScreen.clickOnCheckAvailability();
		
		HomeScreen.clickOnQuickBook();
				
		String full_cancellation_text = HomeScreen.getCencelationPolicyText();
		
		if(HomeScreen.HasCancellation(full_cancellation_text)) {
						
			setTimeStemp(time_stamp);
			
			driverWrapper.takeScreenShot(time_stamp);//"RD_screen2");
			// perform room reservation 
		}
		
		Thread.sleep(1000);
		
	}
	
	
}
