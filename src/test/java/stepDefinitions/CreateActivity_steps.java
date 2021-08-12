package stepDefinitions;

import java.util.List;

import base.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.CreateActivitypayload;
import resources.Endpoints;

public class CreateActivity_steps {

	RequestSpecification request;
	Response response;
	CreateActivitypayload createpayload;

	@Given("admin creates employee")
	public void admin_creates_employee() {
		Base b = new Base();
		CreateActivitypayload createpayload = new CreateActivitypayload();
		RestAssured.baseURI = b.prop.getProperty("Baseurl");
		createpayload.setId(5);
		createpayload.setTitle("RestAssured+Cucumberaaaaaaaa");
		createpayload.setDueDate("2021-08-10T23:31:20.367Z");
		createpayload.setCompleted(true);
		request = RestAssured.given().contentType("application/json").body(createpayload); // log().all();

	}

	/*
	 * @Given("^user creates an activity with (.*) (.*) (.*) (.*)$") public void
	 * user_creates_an_activity(int id,String title,String date,Boolean completed) {
	 * Base b=new Base(); createpayload2=new CreateActivitypayload2();
	 * RestAssured.baseURI=b.prop.getProperty("Baseurl"); createpayload2.id
	 * createpayload.setTitle(title); createpayload.setDueDate(date);
	 * createpayload.setCompleted(completed);
	 * request=RestAssured.given().contentType("application/json")
	 * .body(createpayload).log().all(); }
	 */

	
	  @Given("^user creates an activity with (.*) (.*) (.*) (.*)$") public void
	  user_creates_an_activity(int id,String title,String date,Boolean completed) {
	  Base b=new Base(); createpayload=new CreateActivitypayload();
	  RestAssured.baseURI=b.prop.getProperty("Baseurl"); 
	  createpayload.setId(id);
	  createpayload.setTitle(title); createpayload.setDueDate(date);
	  createpayload.setCompleted(completed);
	  request=RestAssured.given().contentType("application/json")
	  .body(createpayload).log().all(); 
	  }
	 

	@When("user performs a POST call")
	public void user_performs_a_post_call() {
		response = request.when().post(Endpoints.CreateActivity);
		response.then().log().all();
		Generic_Assertion.responsefromsteps = response;
	}

	@Then("{string} has expected values")
	public void has_expected_values(String string, DataTable dataTable) {
		List<String> keylist = dataTable.asList();
		// keylist.stream().forEach(p->System.out.println("values in list: "+p));

		JsonPath js = new JsonPath(response.asString());
		System.out.println("From response: ID:" + js.getInt("id"));
		System.out.println("From response: ID:" + js.getString("title"));
		System.out.println("From pojo derivation: ID:" + createpayload.getId());
		System.out.println("From pojo derivation: Title:" + createpayload.getTitle());
	}

}
