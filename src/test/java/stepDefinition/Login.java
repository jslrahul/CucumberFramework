package stepDefinition;

import io.cucumber.java.en.*;

public class Login {

	
	@Given("User is on the home page")
	public void user_is_on_the_home_page() {
	   System.out.println(">> User is on the home page");
	}

	@When("User enters the username as {string}")
	public void user_enters_the_username_as(String username) {
		System.out.println(">> user enters the username: "+username);
	    
	}

	@When("User enters the password as {string}")
	public void user_enters_the_password_as(String password) {
		System.out.println(">> user enters the password: "+password);  
	}

	@Then("Login should be successful")
	public void login_should_be_successful() {
	    System.out.println(">> user logged into to the application successfully");
	}

	@When("User click on log out button")
	public void user_click_on_log_out_button() {
	    System.out.println(">> user clicks on the log out button");
	}

	@Then("Logout should be successful")
	public void logout_should_be_successful() {
	   System.out.println(">> user is looged out successfully");
	}
	
	@When("User enters the invalid username as {string}")
	public void user_enters_the_invalid_username_as(String username) {
		System.out.println(">> user enters the invalid username: "+username);
	}

	@Then("Error message should be displayed")
	public void error_message_should_be_displayed() {
	    System.out.println(">> Error message should be displayed");
	}

	
}
