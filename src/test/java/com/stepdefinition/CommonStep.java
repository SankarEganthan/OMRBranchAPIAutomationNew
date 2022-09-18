package com.stepdefinition;



import org.junit.Assert;

import com.baseclass.BaseClass;

import io.cucumber.java.en.Then;

public class CommonStep extends BaseClass{
	@Then("User verify the status code is {int}")
	public void userVerifyTheStatusCodeIs(Integer inti) {
		int statusCode = getStatusCode(response);
		Assert.assertEquals("Verify Status Code", 200, statusCode);
	}
}
