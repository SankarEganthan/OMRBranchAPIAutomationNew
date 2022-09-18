package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.AddUserAddress_Input_Pojo;
import com.pojo.AddUserAddress_Output_Pojo;
import com.pojo.DeleteUserAddress_Input_Pojo;
import com.pojo.DeleteUserAddress_Output_Pojo;
import com.pojo.GetUserAddress_Output_Pojo;
import com.pojo.UpdateUserAddress_Input_Pojo;
import com.pojo.UpdateUserAddress_Output_Pojo;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC2_AddressStep extends BaseClass {
	String address_id;

	// Scenario 1
	@When("User add header and basic authentication to add address")
	public void userAddHeaderAndBasicAuthenticationToAddAddress() {
		List<Header> header = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		header.add(h1);
		header.add(h2);
		header.add(h3);

		Headers headers = new Headers(header);
		addHeaders(headers);

	}

	@When("User should enter the address details {string}, {string}, {string}, {string}, {int}, {int}, {int}, {string}, {string} and {string}")
	public void userShouldEnterTheAddressDetailsAnd(String first_name, String last_name, String mobile,
			String apartment, Integer state, Integer city, Integer country, String zipcode, String address,
			String address_type) {
		AddUserAddress_Input_Pojo address_Input_Pojo = new AddUserAddress_Input_Pojo(first_name, last_name, mobile,
				apartment, state, city, country, zipcode, address, address_type);

		addBody(address_Input_Pojo);
	}

	@When("User send {string} request to add user address")
	public void userSendRequestToAddUserAddress(String request) {
		response = requestType(request, Endpoints.ADDUSERADDRESS);
	}

	@Then("User verify the add address output message {string}")
	public void userVerifyTheAddAddressOutputMessage(String rMessage) {
		AddUserAddress_Output_Pojo addUserAddress_Output_Pojo = response.as(AddUserAddress_Output_Pojo.class);
		String message = addUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals("Verify Address added successfully", message, rMessage);
		int id = addUserAddress_Output_Pojo.getAddress_id();
		address_id = String.valueOf(id);
	}

	// Scenario 2
	@When("User add header and basic authentication to update address")
	public void userAddHeaderAndBasicAuthenticationToUpdateAddress() {
		List<Header> header = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		header.add(h1);
		header.add(h2);
		header.add(h3);

		Headers headers = new Headers(header);
		addHeaders(headers);

	}

	@When("User should enter the update address details with address id")
	public void userShouldEnterTheUpdateAddressDetailsWithAddressId() {
		UpdateUserAddress_Input_Pojo updateUserAddress_Input_Pojo = new UpdateUserAddress_Input_Pojo(address_id,
				"Sankar", "Malliga", "7299476012", "CholanNagar", 6, 5, 3, "600109", "Thirumullaivoyal", "Home");
		addBody(updateUserAddress_Input_Pojo);

	}

	@When("User send {string} request to update user address")
	public void userSendRequestToUpdateUserAddress(String request) {
		response = requestType(request, Endpoints.UPDATEUSERADDRESS);

	}

	@Then("User verify the update address output message {string}")
	public void userVerifyTheUpdateAddressOutputMessage(String rMessage) {
		UpdateUserAddress_Output_Pojo as = response.as(UpdateUserAddress_Output_Pojo.class);
		String message = as.getMessage();
		Assert.assertEquals("Verify Address updated successfully", message, rMessage);

	}

	// Scenario 3
	@When("User add header and basic authentication for delete address")
	public void userAddHeaderAndBasicAuthenticationForDeleteAddress() {
		List<Header> header = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.logtoken);
		Header h3 = new Header("Content-Type", "application/json");

		header.add(h1);
		header.add(h2);
		header.add(h3);

		Headers headers = new Headers(header);
		addHeaders(headers);
	}

	@When("User should enter the address id details <address_id>")
	public void userShouldEnterTheAddressIdDetailsAddressId() {
		DeleteUserAddress_Input_Pojo deleteUserAddress_Input_Pojo = new DeleteUserAddress_Input_Pojo(address_id);
		addBody(deleteUserAddress_Input_Pojo);
	}

	@When("User send {string} request to delete user address")
	public void userSendRequestToDeleteUserAddress(String request) {
		response = requestType(request, Endpoints.DELETEUSERADDRESS);
	}

	@Then("User verify the delete address output message {string}")
	public void userVerifyTheDeleteAddressOutputMessage(String rMessage) {
		DeleteUserAddress_Output_Pojo deleteUserAddress_Output_Pojo = response.as(DeleteUserAddress_Output_Pojo.class);
		String message = deleteUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals("Verify delete msg", message, rMessage);
	}

	// Scenario 4

	@When("User add header and basic authentication for get address")
	public void userAddHeaderAndBasicAuthenticationForGetAddress() {
		List<Header> header = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.logtoken);

		header.add(h1);
		header.add(h2);

		Headers headers = new Headers(header);
		addHeaders(headers);
	}

	@When("User send {string} request to get user address")
	public void userSendRequestToGetUserAddress(String request) {
		response = requestType(request, Endpoints.GETUSERADDRESS);
	}

	@Then("User verify the get address output message {string}")
	public void userVerifyTheGetAddressOutputMessage(String rMessage) {
		GetUserAddress_Output_Pojo getUserAddress_Output_Pojo = response.as(GetUserAddress_Output_Pojo.class);
		String message = getUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals("Verify OK", message, rMessage);
	}

}
