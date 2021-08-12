package stepDefinitions;


import base.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.Endpoints;

public class GetActivities_steps {
	public RequestSpecification request;
	public Response response;

	// Scenario1 //
	@Given("admin uses GetEmployees endpoint")
	public void admin_uses_get_employeeendpoint() {
		Base b= new Base();
		RestAssured.baseURI=b.prop.getProperty("Baseurl");
		request=RestAssured.given();
	}

	@When("admin retreives employee details")
	public void admin_retreives_employee_details() {
		response=request.when().get(Endpoints.GetActivites);
		System.out.println("Endpoint: "+Endpoints.GetActivites);
		Generic_Assertion.responsefromsteps=response;
	}

	//Scenario2//
	@Given("admin uses GetSingleEmployee {int} endpoint")
	public void admin_uses_get_single_employee_endpoint(Integer id) {
		admin_uses_get_employeeendpoint();
		request=request.given().pathParam("id",id);//.log().all();	
	}

	@When("admin retreives single employee details")
	public void admin_retreives_single_employee_details() {
		response=request.when().get(Endpoints.GetSingleActivity);
		Generic_Assertion.responsefromsteps=response;
	}


}
