package stepDefinitions;

import java.io.IOException;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.FreeListing;

public class LaunchFreeListing extends BaseClass{
	
	FreeListing fl= new FreeListing(getDriver());
	
	@Given("the user clicks on FreeListing")
	public void the_user_clicks_on_free_listing() {
		logger.info("<------FreeListing Test Scenario Execution Started succesfully------>");
	   fl.handlePopupWindow();
	   fl.LaunchFreeListing();
	   logger.info("FreeListing is launched");
	}

	@When("FreeListing is opened user enters wrong details and click on start now button")
	public void free_listing_is_opened_user_enters_wrong_details_and_click_on_start_now_button() throws InterruptedException {
		
		fl.enterWrongDetail();
		fl.clickStartNowBtn();
		logger.info("Wrong Detail is entered and Start Now button is clicked");
	   
	}

	@Then("the user print the invalid displayed message and navigate back to justdial website")
	public void the_user_print_the_invalid_displayed_message_and_navigate_back_to_justdial_website() throws InterruptedException, IOException {
		
		fl.printInvalidMsg();
		logger.info("Invalid message is printed");
		BaseClass.takeScreenshot("FreeListing");
		
		fl.navigateBack();
		logger.info("*****Window navigated back successfully*****");
		logger.info("<------FreeListing Test Scenario Execution Started succesfully------>");
		
	}


}
