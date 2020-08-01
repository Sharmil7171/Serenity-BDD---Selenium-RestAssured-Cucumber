package com.studentapp.cucumber.serenity;

import com.app.model.UserModel;
import com.studentapp.utils.ReusableSpecifications;
import com.studentapp.utils.TestUtils;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class UserSerenitySteps {
	
	@Step("Creating new user with Name: {0}, Job: {1}")
	public ValidatableResponse createUser(String name, String job) {
		UserModel newUser = new UserModel();
		newUser.setName(name);
		newUser.setJob(job);
		
		return SerenityRest
		.rest()
		.given()
		.spec(ReusableSpecifications.getGenericRequestSpec())
		.when()
		.body(newUser)
		.post("/users")
		.then();
	}
	
	
	@Step("Getting all the User Information")
	public ValidatableResponse getUsersInfo() {
		
		return SerenityRest
		.rest()
		.given()
		.when()
		.get("/users")
		.then();
	}
	
	
	
	@Step("Updating user information with Job: {0}")
	public ValidatableResponse updateUserInfo(String jobTitle) {
		UserModel newUser = new UserModel();
		newUser.setName(TestUtils.getRandomName());
		newUser.setJob(jobTitle);
		
		return SerenityRest
		.rest()
		.given()
		.spec(ReusableSpecifications.getGenericRequestSpec())
		.log()
		.all()
		.when()
		.body(newUser)
		.put("/users")
		.then();
	}
	
	@Step("Deleting User from the list")
	public ValidatableResponse deleteUser() {
		return SerenityRest
		.rest()
		.given()
		.when()
		.delete("/users/2")
		.then();
	}
}
