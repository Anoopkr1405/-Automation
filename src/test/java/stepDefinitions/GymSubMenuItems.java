package stepDefinitions;

import java.io.IOException;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.GymsSubList;

public class GymSubMenuItems extends BaseClass {
	
	 GymsSubList gs= new GymsSubList(getDriver());
	 
	@When("user clicks on Gym nearby location gyms are displayed")
	public void user_clicks_on_gym_nearby_location_gyms_are_displayed() throws InterruptedException {
		logger.info("<------Gym Test Scenario Execution Started succesfully------>");
		gs.handlePopupWindow();
	    gs.FindGym();
	    logger.info("Gym section under fitness is clicked");
	}

	@Then("user print the sub-Menu items of Gyms and store it in excel")
	public void user_print_the_sub_menu_items_of_gyms_and_store_it_in_excel() throws InterruptedException, IOException {
		
		gs.printGymSubList();
		logger.info("*****Sub-menu Items of Gyms are printed*****");
		
		BaseClass.takeScreenshot("GymSubList");
		
		logger.info("***Screenshot of Gym sub-Menu items taken successfully***");
		
	}
	
	@Then("user print available dropdown list of Sub-Menu gym items")
	public void user_print_available_dropdown_list_of_sub_menu_gym_items() throws IOException {
		
		gs.subMenuDetails();
		logger.info("Dropdown List of sub-menu gym items are printed");
		logger.info("<------Gym Test Scenario Execution Ended succesfully------>");
	   

}
}
