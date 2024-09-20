package tests;


import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;

import static org.hamcrest.Matchers.equalTo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class xmlSchemaValidation {


	@Test
	public void schemaValidation() throws IOException {
	    // Set the base URI for the request explicitly
	    RestAssured.baseURI = "http://www.dneonline.com";

	    // Load SOAP request from XML file
	    File file = new File("./SoapRequest/Add.xml");
	    String requestBody;

	    try (FileInputStream fileInputStream = new FileInputStream(file)) {
	        requestBody = IOUtils.toString(fileInputStream, "UTF-8");
	    }

	    // Send the SOAP request and validate the response
	    given()
	        .contentType("text/xml")
	        .accept(ContentType.XML)
	        .body(requestBody)
	    .when()
	        .post("/calculator.asmx")
	    .then()
	        .statusCode(200)
	        .log().all()
	        .body("//*:AddResult.text()", equalTo("12"))
	        .assertThat()
	        .body(matchesXsdInClasspath("Calculator.xsd"));  // Ensure XSD is in classpath
	}
}
