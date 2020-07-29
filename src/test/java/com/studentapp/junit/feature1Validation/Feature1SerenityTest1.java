package com.studentapp.junit.feature1Validation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Manual;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Title;


//In serenity every test class displayed as a separate story in report

// To run this test with Serenity we required this @RunWith class tag
@RunWith(SerenityRunner.class)
public class Feature1SerenityTest1 {
	
	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "https://reqres.in/api";
	}
	
	
	@Test
	public void getAllStudents() {
		
		// This is serenity wrapper on the top of Rest Assured framework
		SerenityRest.given()
		.when()
		.get("/users?page=2")
		.then()
		.log()
		.all()
		.statusCode(200);
		
		
		// Usual Rest assured test
//		RestAssured.given()
//		.when()
//		.get("/users?page=2")
//		.then()
//		.log()
//		.all()
//		.statusCode(200);
	}
	
	@Test
	public void failingTest() {
		// Actual status code is 200 while expected is 500 here 
		SerenityRest.given()
		.when()
		.get("/users?page=2")
		.then()
		.log()
		.all()
		.statusCode(500);
	}
	
	@Pending
	@Test
	public void pendingTest() {
		
	}
	
	@Ignore
	@Test
	public void skippedTest() {
		
	}
	
	
	@Test
	public void errorTest() {
		System.out.println("This is an error" + (5/0));
	}
	
	
	@Test
	public void fileDoesNotExist() throws FileNotFoundException {
		File f = new File("/file.txt");
		FileReader fr = new FileReader(f);
	}
	
	@Manual
	@Test
	public void manualTest() {
		
	}
	
	
	@Title("This test has title annotation with it")
	@Test
	public void test1() {
		
		// This is serenity wrapper on the top of Rest Assured framework
		SerenityRest.given()
		.when()
		.get("/users?page=2")
		.then()
		.log()
		.all()
		.statusCode(200);
	}
}
