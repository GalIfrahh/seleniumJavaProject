import io.qameta.allure.*;
import org.junit.Test;
import PageObjects.PageObjects.*;
import static org.junit.jupiter.api.Assertions.*;


@Story("Sanity")

public class SanityTests extends Basic {



    @Test
    @Description("E2E - user make full flow with adding cc")
    @Severity(SeverityLevel.BLOCKER)
    public void redLionSanity() {

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
