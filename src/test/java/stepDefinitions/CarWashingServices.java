package stepDefinitions;

import java.io.IOException;


import org.junit.Assert;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CarWashing;

public class CarWashingServices extends BaseClass {
	 CarWashing cw=new CarWashing(getDriver());

	@Given("the user navigate to justdial website")
	public void the_user_navigate_to_justdial_website() {
		logger.info("<------Car Washing services Test Scenario Execution Started------>");
	   boolean logo=cw.verifyLogo();
	   Assert.assertEquals(logo, true);
	   logger.info("Justdial logo is verified successfully");
	}

	@Then("the user handles the popup")
	public void the_user_handles_the_popup() {
		
		
		try {
			cw.handlePopupWindow();;
			System.out.println("Popup appeared and Handled");
		}
		catch(Exception e) {
			System.out.println("Popup didn't appeared");
	}
		logger.info("Popup Handled succesfully");
}

	@Then("the user select current Location and enter car washing services in search box")
	public void the_user_select_current_location_and_enter_car_washing_services_in_search_box() throws InterruptedException {
		
		cw.enterLocation();
		cw.selectLocation();
		logger.info("Current location is selected");
		
		cw.enterCarWashServices();
		cw.selectButton();
		cw.clickSearchButton();
		logger.info("Searched Car washing services are visible on screen");
		
	}

	@When("the user click on AllFilters and select rating greater than four")
	public void the_user_click_on_all_filters_and_select_rating_greater_than_four() throws InterruptedException {
	
		cw.clickAllFilters();
		cw.clickRating();
		cw.clickApplyFilter();
		cw.handleLastPopupWindow();
		logger.info("4.0+ rating filter is applied after clicking on rating filter under AllFilters tag");

	    
	}

	@Then("name and contact number of Car washing services are printed")
	public void name_and_contact_number_of_car_washing_services_are_printed() throws InterruptedException, IOException {
		
		logger.info("*****Car Washing services name and rating is printed on console and excel*****");
		cw.clickContactFlareBtn();
		cw.printCarSrvcNames();
		
		BaseClass.takeScreenshot("CarServicesDetails");
		logger.info("***Screenshot of Car washing services taken successfully***");
		logger.info("<------Car Washing services Test Scenario Execution ended successfully------>");
		
	    
	}


}
