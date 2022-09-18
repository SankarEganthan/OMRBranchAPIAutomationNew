package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.baseclass.BaseClass;
import com.reports.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(dryRun = false, stepNotifications = false, snippets = SnippetType.CAMELCASE, plugin = {"json:target//Output.json"}, features = "src\\test\\resources", glue="com.stepdefinition")
public class TestRunnerClass extends BaseClass {
	@AfterClass
	public static void afterClass() {
		System.out.println("Report Started");
		Reporting.generateJVMReport(System.getProperty("user.dir")+"\\target\\Output.json");
		System.out.println("Report Created");
	}
	
}
