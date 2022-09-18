package com.reports;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting {
	public static void generateJVMReport(String jsonFile) {
		File file = new File(System.getProperty("user.dir") + "\\target");
		
		Configuration configuration = new Configuration(file, "OMRBranchAPIAutomation");
		configuration.addClassifications("OS", "WIN8");
		configuration.addClassifications("API", "OMRBranchAPI");
		
		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);
		
		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		reportBuilder.generateReports();
	}
}
