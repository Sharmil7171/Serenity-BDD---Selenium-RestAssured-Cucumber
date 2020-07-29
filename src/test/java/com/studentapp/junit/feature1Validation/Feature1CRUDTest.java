package com.studentapp.junit.feature1Validation;

import java.util.HashMap;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import com.app.model.AccountDetailModel;
import com.app.model.UserModel;
import com.studentapp.testbase.TestBase;
import com.studentapp.utils.TestUtils;

import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import static org.hamcrest.Matchers.hasValue;
import static org.junit.Assert.assertThat;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Feature1CRUDTest extends TestBase{
	
	// CRUD - create, read, update, delete
	
	@Title("This test will create a new User in list")
	@Test
	public void test001() {
//		AccountDetailModel newAccount = new AccountDetailModel();
//		newAccount.setId(20);
//		newAccount.setEmail("testId@gmail.com");
//		newAccount.setFirst_name("Test_First_Name");
//		newAccount.setLast_name("Test_Last_Name");
//		newAccount.setAvatar("Test_Avatar_JPG");
		
		UserModel newUser = new UserModel();
		newUser.setName(TestUtils.getRandomName());
		newUser.setJob("leader");
		
		SerenityRest
		.rest()
		.given()
		.contentType(ContentType.JSON)
		.log()
		.all()
		.when()
		.body(newUser)
		.post("/users")
		.then()
		.log()
		.all()
		.statusCode(201);
	}
	
	@Title("Verify the User is added to the list")
	@Test
	public void test002() {
//		String fName = "Emma";
//		
//		HashMap<String, Object> value = SerenityRest
//		.rest()
//		.given()
//		.when()
//		.get("/users")
//		.then()
//		.log()
//		.all()
//		.statusCode(200)
//		.extract()
//		.path("findAll{it.firstName=='"+ fName +"'}.get(0)");
//		
//		System.out.println("The Value is:" + value);
//		assertThat(value, hasValue(fName));
	}
	
	
	@Title("Update the User information and verify the User info in the list")
	@Test
	public void test003() {
		String updatedJob = "worker";
		
		UserModel newUser = new UserModel();
		newUser.setName(TestUtils.getRandomName());
		newUser.setJob(updatedJob);
		
		
		
		SerenityRest
		.rest()
		.given()
		.contentType(ContentType.JSON)
		.log()
		.all()
		.when()
		.body(newUser)
		.put("/users")
		.then()
		.log()
		.all()
		.statusCode(200);
	}
	
	
	@Title("Delete the student and verify the student is deleted")
	@Test
	public void test004() {	
		
		SerenityRest
		.rest()
		.given()
		.when()
		.delete("/users/2")
		.then()
		.log()
		.all()
		.statusCode(204);	
		
	}
	
}
