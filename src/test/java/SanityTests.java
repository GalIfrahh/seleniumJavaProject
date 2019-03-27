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
