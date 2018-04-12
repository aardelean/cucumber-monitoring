package de.tetralog.v4wsmonitor;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class VersionControllerTest {
    private static final String BASE_URL = "http://localhost";
    private static final int PORT = 7070;

    private RequestSpecification requestSpecification;
    private ValidatableResponse response;

    @Given("^the client has server url")
    public void the_client_configures_url() {
        requestSpecification = given()
                .config(RestAssuredConfig.config())
                .baseUri(BASE_URL)
                .accept(ContentType.ANY)
                .port(PORT);
    }


    @When("^the client calls (.+)$")
    public void the_client_issues_GET_version(String path) throws Throwable{
        response = requestSpecification.get(path).then();
    }

    @Then("^the client receives status code of (\\d+)$")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
        response.statusCode(statusCode);
    }

    @And("^the client receives server version (.+)$")
    public void the_client_receives_server_version_body(String version) throws Throwable {
        response.body(containsString(version));
    }
}
