package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.Login_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class TC1_LoginStep extends BaseClass {
	public static String logtoken;

	@Given("User add header")
	public void userAddHeader() {
		addHeader("accept", "application/json");
	}

	@Given("User add basic authentication for login")
	public void userAddBasicAuthenticationForLogin() throws FileNotFoundException, IOException {
		basicAuth(getPropertyFileValue("userName"), getPropertyFileValue("password"));
		
	}

	@When("User send {string} request for login endpoint")
	public void userSendRequestForLoginEndpoint(String request) {
		response = requestType(request, Endpoints.POSTMANBASICAUTHLOGIN);
		
	}

	@Then("User verify the login response body firstName present as {string} and get the logtoken saved")
	public void userVerifyTheLoginResponseBodyFirstNamePresentAsAndGetTheLogtokenSaved(String firstName) {
		Login_Output_Pojo login_Output_Pojo = response.as(Login_Output_Pojo.class);
		String first_name = login_Output_Pojo.getData().getFirst_name();
		 Assert.assertEquals("Verify first name", first_name, firstName);

		logtoken = login_Output_Pojo.getData().getLogtoken();

	}
}
