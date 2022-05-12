package com.selenium.jira;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface JiraAnnotation {

	boolean createIssue();
	
	
	
	
	
}
