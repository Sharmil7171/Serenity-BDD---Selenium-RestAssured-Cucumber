package com.studentapp.junit.feature1Validation;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import com.studentapp.cucumber.serenity.UserSerenitySteps;
import com.studentapp.testbase.TestBase;
import com.studentapp.utils.ReusableSpecifications;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;


@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Feature1CRUDTest extends TestBase{
	
	// CRUD - create, read, update, delete
	@Steps
	UserSerenitySteps steps;
	
	
	@Title("This test will create a new User in list")
	@Test
	public void test001() {
		steps.createUser("Sam", "Software Engineer")
		.statusCode(201)
		.spec(ReusableSpecifications.getGenericResponseSpec());
	}
	
	
	@Title("Verify the User is added to the list")
	@Test
	public void test002() {
		steps.getUsersInfo()
		.log().all()
		.statusCode(200)
		.spec(ReusableSpecifications.getGenericResponseSpec());
	}
	
	
	@Title("Update the User information and verify the User info in the list")
	@Test
	public void test003() {
		steps.updateUserInfo("Software Developer")
		.statusCode(200)
		.spec(ReusableSpecifications.getGenericResponseSpec());
	}
	
	
	@Title("Delete the student and verify the student is deleted")
	@Test
	public void test004() {	
		
		steps.deleteUser()
		.log().all()
		.statusCode(204);	
	}
	
}
