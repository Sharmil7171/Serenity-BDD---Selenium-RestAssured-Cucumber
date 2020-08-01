package com.studentapp.junit.feature1Validation;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.studentapp.cucumber.serenity.UserSerenitySteps;
import com.studentapp.testbase.TestBase;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;

// Run Parallel testing using @Concurrent -- this will only work with Data Driven Serenity test
// By default if you just provide @Concurrent it will take 2 thread from every CPU core
// If you want more thread then @Concurrent(threads="4x") -- this will start 4 threads from every core
@Concurrent
@UseTestDataFrom("testdata/UserInfo.csv")
@RunWith(SerenityParameterizedRunner.class)
public class Feature1DataDrivenTest extends TestBase{

	//********** To create random mock data, use this website - www.mockaroo.com
	
	
	private String name;
	private String job;

	@Steps
	UserSerenitySteps steps;
	
	@Title("Data Driven test for adding new User in users list")
	@Test
	public void createNewUser() {
		steps.createUser(name, job).log().all().statusCode(201);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
}
