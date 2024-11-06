REST Assured API Testing Framework
This project is a REST Assured framework for automating CRUD (Create, Read, Update, Delete) operations on RESTful APIs. It provides a structured approach to testing API endpoints by integrating REST Assured with Java, enabling testers to build and execute test cases for API functionalities effectively. The framework is designed to be easy to use, scalable, and adaptable to various API testing needs.

Table of Contents
Getting Started
Features
Project Structure
Setup and Installation
Usage
Test Execution
Reports
Contributing

Getting Started
This REST Assured framework is suitable for testing REST APIs in any environment, including local and cloud-based APIs. The framework supports testing various types of HTTP requests like POST, GET, PUT, PATCH, and DELETE to verify the API's functionality.

Features
CRUD Operation Automation: Supports automated testing of CRUD operations (Create, Read, Update, Delete).
Data-Driven Testing: Easily configurable to run data-driven tests with JSON or external data sources.
Detailed Reporting: Generates detailed HTML reports for test execution.
Modular Design: Organized structure to add test cases or new API modules with ease.
Environment Configurations: Manage multiple environment configurations (e.g., dev, staging, production) using property files.
Error Handling and Validations: Includes checks for response codes, response times, schema validation, and content assertions.
Project Structure
The project follows a standard folder structure:

scss
Copy code
rest-assured-api-framework
│
├── src
│   ├── main
│   │   └── java
│   │       └── com.example.api // Core classes and configuration
│   └── test
│       └── java
│           └── com.example.api.tests // Test cases for CRUD operations
│
├── resources
│   ├── config.properties // Configurations like base URL, timeout settings
│   └── test-data // JSON files or other data sources
│
├── reports // Generated test reports
│
├── pom.xml // Maven dependencies
└── README.md
Setup and Installation
Clone the Repository:

bash
Copy code
git clone https://github.com/username/rest-assured-api-framework.git
cd rest-assured-api-framework
Prerequisites:

Java 8 or higher: Install from here
Maven: Install from here
Install Dependencies: Run the following Maven command to download dependencies:

bash
Copy code
mvn clean install
Usage
Configuring Endpoints
Set up your API endpoints and credentials in config.properties for environment-specific configurations.
Use JSON files in test-data for request payloads or to drive data-driven tests.
Writing Test Cases
Extend the base test class for CRUD operations.
Define test methods using REST Assured syntax:
java
Copy code
@Test
public void testCreateResource() {
    given()
        .contentType("application/json")
        .body(newResourceData)
    .when()
        .post("/resource")
    .then()
        .statusCode(201)
        .body("id", notNullValue());
}
Test cases can be organized by functionality (e.g., create tests, read tests, etc.) for better structure and readability.
Test Execution
Run All Tests: Execute the following Maven command:

bash
Copy code
mvn test
Run Specific Tests: Use the following command to execute a single test file:

bash
Copy code
mvn -Dtest=TestClassName test
Reports
After executing the tests, reports will be generated under the reports directory in HTML format. These reports provide detailed results for each test case, including:

Status of each CRUD operation (pass/fail)
Response times and payloads
Any assertion or validation errors
Contributing
Contributions are welcome! Please fork this repository, create a branch for your feature or bug fix, and submit a pull request for review.
