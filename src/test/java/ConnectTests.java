import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import org.openqa.selenium.By;
import PageObjects.PageObjects.HomeScreen;



public class ConnectTests extends Basic {


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

  }
