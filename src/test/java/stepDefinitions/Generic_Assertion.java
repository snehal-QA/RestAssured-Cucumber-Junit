package stepDefinitions;


import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.restassured.response.Response;

public class Generic_Assertion {
	public static Response responsefromsteps;

	@Then("status code {int} is returned")
	public void status_code_is_returned(int statuscode) {
		Assert.assertEquals(responsefromsteps.getStatusCode(),statuscode);
		responsefromsteps.then().log().all();
	}
}
