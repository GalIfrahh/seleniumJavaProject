import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import PageObjects.PageObjects.*;

import static org.junit.Assert.*;

public class SanityTests extends Basic {


    public String time_stamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());


    @Test
    public void redLionSanity() throws InterruptedException {

        HomePage.openRedLion();

        ConnectPage.clickOnHelloRewards_connectBtn();

        ConnectPage.enterEmail(prop.getProperty("EMAIL"));

        ConnectPage.enterPassword(prop.getProperty("PASSWORD"));

        ConnectPage.clickOnSignIn();



        HomePage.enterLocationName(prop.getProperty("CITY_TO_SEARCH"));

        HomePage.chooseFirstLocation();

        HomePage.clickOnStartDateField();

        int active_date = HomePage.getSelectedStartDateIndex(HomePage.getDatePickerValues());

        HomePage.getDatePickerValues().get(active_date + 7).click();

        HomePage.getDatePickerValues().get(active_date + 8).click();

        HomePage.clickOnCheckAvailability();

        HomePage.clickOnQuickBook();



        ConfirmationPage.enterPhoneNumber(prop.getProperty("PHONE_NUMBER"));

        ConfirmationPage.enterPostalCode(prop.getProperty("POSTAL_CODE"));

        ConfirmationPage.clickOnMangePaymentMethods();

        ConfirmationPage.clickOnAddNewCard();


        String full_cancellation_text = OrderSummeryPage.getCancellationPolicyText();

        if(OrderSummeryPage.HasCancellation(full_cancellation_text)) {

            setTimeStemp(time_stamp);

            driverWrapper.takeScreenShot(time_stamp);
            
            
            // perform room reservation - needs real payment methods...

            
            String confirmation_text = ConfirmationPage.getConfirmationText();


            assertEquals(confirmation_text, prop.getProperty("CONFIRMATION_TEXT"));
        }


		else{

                fail("no cancellation policy");

            }


        }

}
