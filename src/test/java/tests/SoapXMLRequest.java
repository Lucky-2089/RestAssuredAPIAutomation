package tests;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import org.apache.commons.io.IOUtils; 
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import static org.hamcrest.Matchers.equalTo;

public class SoapXMLRequest {

	@Test
	public void validateSoapXML() throws IOException {
		// Load SOAP XML request from file
		File file = new File("./SoapRequest/Add.xml");
		FileInputStream fileInputStream = null;
		String requestBody = "";

		try {
			fileInputStream = new FileInputStream(file);
			// Convert the file input stream to a string using IOUtils
			requestBody = IOUtils.toString(fileInputStream, "UTF-8");
		} finally {
			if (fileInputStream != null) {
				System.out.println("File exits");
				fileInputStream.close();  // Ensure the stream is closed
			}
		}

		// Set the base URI for the request
		baseURI = "http://www.dneonline.com";

		// Send the SOAP request and validate the response
		given()
		.contentType("text/xml")
		.accept(ContentType.XML)
		.body(requestBody)
		.when()
		.post("/calculator.asmx")  // Specify the endpoint for the SOAP service
		.then()
		.statusCode(200)  // Expecting HTTP 200 OK response
		.log().all()     // Log the full response for debugging
		.and()
		.body("//*:AddResult.text()",equalTo("12"));
	}
}