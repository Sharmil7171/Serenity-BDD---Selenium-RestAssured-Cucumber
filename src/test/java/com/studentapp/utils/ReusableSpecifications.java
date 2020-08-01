package com.studentapp.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

public class ReusableSpecifications {
	
	public static RequestSpecBuilder reqspec;
	public static RequestSpecification reqSpecification;
	
	public static ResponseSpecBuilder resspec;
	public static ResponseSpecification resSpecification;
	
	public static RequestSpecification getGenericRequestSpec() {
		// Add request specifications which are default and mandatory for any request we are making 
		reqspec = new RequestSpecBuilder();
		reqspec.setContentType(ContentType.JSON);
		
		// Build that spec and return it back so that we have the initial request 
		reqSpecification = reqspec.build();
		
		return reqSpecification;
	}
	
	
	public static ResponseSpecification getGenericResponseSpec() {
		
		resspec = new ResponseSpecBuilder();
		resspec.expectHeader("Content-Type", "application/json; charset=utf-8");
		//This spec will check the response time is less than 5 seconds
		resspec.expectResponseTime(lessThan(5L), TimeUnit.SECONDS);
		
		resSpecification = resspec.build();
		
		return resSpecification;
		
	}
}
