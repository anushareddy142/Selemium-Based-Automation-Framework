package com.selenium.jira;

import java.io.IOException;

import com.selenium.testbase.PropertyReader;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.Issue.FluentCreate;
import net.rcarz.jiraclient.JiraClient;

public class JiraHelper {

	private BasicCredentials jiraCredentials;
	private JiraClient jiraClient;
	private String jiraProject;
	private String jiraURL;
	private String jiraPassword;
	private String jiraUserName;

	public JiraHelper() throws IOException {

		jiraProject = PropertyReader.readProperty("jiraProjectKey");
		jiraURL = PropertyReader.readProperty("jiraurl");
		jiraPassword = PropertyReader.readProperty("jiraPassword");
		jiraUserName = PropertyReader.readProperty("jiraUserName");
	}

	public void authenticateJira() {
		// prepare authentication details
		// BasicCredentials jiraCredentials = new
		// BasicCredentials(jiraUserName,jiraPassword);
		jiraCredentials = new BasicCredentials(jiraUserName, jiraPassword);

		// Start Authentication proceess we use JiraClient class
		// JiraClient jiraClient = new JiraClient(jiraURL,jiraCredentials);
		jiraClient = new JiraClient(jiraURL, jiraCredentials);
	}
public void createJiraIssue(String issueType, String issueSummary, String issueDescription)
{
	
	try {
		FluentCreate createIssue= jiraClient.createIssue(jiraProject, issueType);// this method return reference of FluentCreate Class
		//preparing all the fields data to submit in jira
		createIssue.field(Field.ISSUE_TYPE, issueType);
		createIssue.field(Field.SUMMARY, issueSummary);
		createIssue.field(Field.DESCRIPTION,issueDescription);
		 //submit all data to jira
	Issue issueId = 	createIssue.execute();
	System.out.println(issueId);
	}
	
	catch(Exception ex) {
	ex.printStackTrace();
}
	
	
}
}

