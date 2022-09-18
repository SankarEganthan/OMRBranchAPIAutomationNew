package com.stepdefinition;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.ChangeProfilePic_Output_pojo;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;

public class TC3_ChangeProfilePicStep extends BaseClass{
	@When("User add header and basic authentication to change profile pic")
	public void userAddHeaderAndBasicAuthenticationToChangeProfilePic() {
		List<Header> header = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.logtoken);
		Header h3 = new Header("Content-Type", "multipart/form-data");

		header.add(h1);
		header.add(h2);
		header.add(h3);

		Headers headers = new Headers(header);
		addHeaders(headers);

	}
	@When("User send {string} request to change profile pic")
	public void userSendRequestToChangeProfilePic(String request) {
		formData("profile_picture", new File(System.getProperty("user.dir")+"\\Images\\SankarPic.jpg"));
		response = requestType(request, Endpoints.CHANGEPROFILEPIC);
	}
	@Then("User verify the profile pic updated message {string}")
	public void userVerifyTheProfilePicUpdatedMessage(String string) {
		ChangeProfilePic_Output_pojo changeProfilePic_Output_pojo = response.as(ChangeProfilePic_Output_pojo.class);
		String message = changeProfilePic_Output_pojo.getMessage();
		Assert.assertEquals("Verify profile updated successfully", message, "Profile updated Successfully");
	}

}
