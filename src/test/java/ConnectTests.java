import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import io.qameta.allure.*;
import PageObjects.PageObjects;
import org.junit.Test;
import org.openqa.selenium.By;
import PageObjects.PageObjects.ConnectPage;


@Story("Connect flows")

public class ConnectTests extends Basic {

	
	
      @Test
      @Description("user perform login by email as user name & password")
      @Severity(SeverityLevel.CRITICAL)
      public void login(){

          PageObjects.HomePage.openRedLion();

          ConnectPage.clickOnHelloRewards_connectBtn();

          ConnectPage.enterEmail(prop.getProperty("EMAIL"));

          ConnectPage.enterPassword(prop.getProperty("PASSWORD"));

          ConnectPage.clickOnSignIn();

          String user_name = ConnectPage.getUserName();

          assertEquals(user_name, prop.getProperty("EMAIL"));
    }

  }
