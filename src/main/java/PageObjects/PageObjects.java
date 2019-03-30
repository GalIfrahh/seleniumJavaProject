package PageObjects;
import java.util.List;
import org.openqa.selenium.WebElement;
import Infrastructure.GenericPageObject;
import Infrastructure.Locators;


public class PageObjects {



	public static class HomePage extends GenericPageObject{


		static final String SUT_URL = "https://www.redlion.com/";
		static final String LOCATION_FIELD = "globalSearchInput";
		static final String FIRST_LOCATION = "//ul/li[@class='typeahead__item typeahead__group-cities'][1]";
		static final String DATE_PICKER_FIELD = "searchStartDate";
		static final String DATE_PICKER_VALUES = "//div[@id='searchCalendar']/section[@class='PAmonth PAfrom']/span";
		static final String ACTIVE_DATE_CLASS_VALUE = "PAselected PAfrom PAactive";
		static final String CHECK_AVAILABILITY_BTN = "//button[@class='btn-primary waves-effect waves-red check-availability-button']";
		static final String QUICK_BOOK_BTN = "//button[@class='btn-primary waves-effect waves-red'][text()='Quick Book']";



		public static void openRedLion() {

			driverWrapper.open(SUT_URL);

		}


		public static void enterLocationName(String city_to_search) {

			driverWrapper.findElementBy(Locators.ID, LOCATION_FIELD).sendKeys(city_to_search);

		}


		public static void chooseFirstLocation() {

			driverWrapper.findElementBy(Locators.XPATH, FIRST_LOCATION).click();
		}


		public static void clickOnStartDateField() {

			driverWrapper.findElementBy(Locators.ID, DATE_PICKER_FIELD).click();
		}


		public static List<WebElement> getDatePickerValues() {

			return driverWrapper.findElementsBy(DATE_PICKER_VALUES);
		}


		public static int getSelectedStartDateIndex(List<WebElement> date_picker_values) {

			int i;

			int selected_date_index = 0;


			for(i=0; i<date_picker_values.size(); i++) {


				if (date_picker_values.get(i).getAttribute("class").equals(ACTIVE_DATE_CLASS_VALUE)) {

					selected_date_index = i;

					break;

				}

			}

			return selected_date_index;
		}


		public static void clickOnCheckAvailability() {

			driverWrapper.findElementBy(Locators.XPATH, CHECK_AVAILABILITY_BTN).click();
		}


		public static void clickOnQuickBook() {

			driverWrapper.findElementBy(Locators.XPATH, QUICK_BOOK_BTN).click();
		}


	}



	public static class ConnectPage extends GenericPageObject{


		static final String HELLO_REWARDS_BUTTON = "oktaToggleTitle";
		static final String HELLO_REWARDS_POP_UP = "//div[@class=\'jBox-container\']/div[2]";
		static final String EMAIL_FIELD = "oktaToggleEmail";
		static final String PASSWORD_FIELD = "oktaTogglePassword";
		static final String SIGN_IN_BTN = "oktaToggleSubmit";
		static final String USER_NAME_FIELD = "username";



		public static void clickOnHelloRewardsPopup() {

			driverWrapper.findElementBy(Locators.XPATH, HELLO_REWARDS_POP_UP).click();
		}


		public static void clickOnHelloRewards_connectBtn() {

			driverWrapper.findElementBy(Locators.ID, HELLO_REWARDS_BUTTON).click();
		}


		public static void enterEmail(String email) {

			driverWrapper.findElementBy(Locators.ID, EMAIL_FIELD).sendKeys(email);
		}


		public static void enterPassword(String password) {

			driverWrapper.findElementBy(Locators.ID, PASSWORD_FIELD).sendKeys(password);
		}


		public static void clickOnSignIn() {

			driverWrapper.findElementBy(Locators.ID, SIGN_IN_BTN).click();


			driverWrapper.waitForElement();
		}


		public static String getUserName(){

			return driverWrapper.findElementBy(Locators.ID, USER_NAME_FIELD).getText();
		}
	}


	public static class OrderSummeryPage extends GenericPageObject{


		static final String CANCELLATION_POLICY = "//a[text()='Cancellation Policy']";
		static final String CANCELLATION_POPUP = "//div[@class='tipso_bubble top animated fade-in-down']";
		static final String HAS_CANCELLATION_TEXT = "at least 24 hours prior to arrival to avoid a 1 night";



		public static String getCancellationPolicyText() throws InterruptedException {

			driverWrapper.scrollToElement(CANCELLATION_POLICY);


			driverWrapper.hover(CANCELLATION_POLICY);


			return driverWrapper.findElementBy(Locators.XPATH, CANCELLATION_POPUP).getText();

		}


		public static boolean HasCancellation(String full_cancellation_text) {

			boolean has_cancellation = false;


			if (full_cancellation_text.contains(HAS_CANCELLATION_TEXT)){


				has_cancellation = true;


			}

			return has_cancellation;
		}

	}



	public static class ConfirmationPage extends GenericPageObject{


		static final String CONFIRMATION_FIELD = "//div[@class='conf_text_area']";
		static final String PHONE_NUMBER_FIELD = "checkout-form-phone-number";
		static final String POSTAL_CODE_FIELD = "checkout-form-zip-code";
		static final String MANAGE_PAYMENT_METHODS_VIEW = "//*[@id='checkoutPayment']/div/div/header/h4";
		static final String MANAGE_PAYMENT_METHODS_BTN = "//*[@id='myc-wallet']/div/div/div[4]/div[2]/div/span";
		static final String ADD_NEW_CARD_BTN = "//div[@class='myc-wallet-common']/div[@id='myc-wallet-modal-outer']/div[1]/div[2]/div[1]/div[2]/ul/li[1]/span[text()='ADD NEW CARD']";



		public static String getConfirmationText(){

			return driverWrapper.findElementBy(Locators.XPATH, CONFIRMATION_FIELD).getText();
		}


		public static void enterPhoneNumber(String Phone_number){

			driverWrapper.findElementBy(Locators.ID, PHONE_NUMBER_FIELD).sendKeys(Phone_number);

		}


		public static void enterPostalCode(String postal_code){

			driverWrapper.findElementBy(Locators.ID, POSTAL_CODE_FIELD).sendKeys(postal_code);

		}


		public static void clickOnMangePaymentMethods(){

			driverWrapper.scrollToElement(MANAGE_PAYMENT_METHODS_VIEW);


			driverWrapper.waitForElement();


			driverWrapper.waitForElemToBeClickable(MANAGE_PAYMENT_METHODS_BTN).click();
		}


		public static void clickOnAddNewCard(){

			driverWrapper.waitForElemToBeClickable(ADD_NEW_CARD_BTN).click();

		}
	}

}
