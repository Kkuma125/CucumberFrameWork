package parallel;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import com.qa.factory.DriverFactory;
import com.qa.pages.ContactUsPage;
import com.qa.utils.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsSteps {

	private ContactUsPage contactUsPage = new ContactUsPage(DriverFactory.getDriver()); 


	@Given("user navigates to contact us page")
	public void user_navigates_to_contact_us_page() {
		DriverFactory.getDriver().get("http://automationpractice.pl/index.php?controller=contact");

	}

	@When("user fills the form from given sheetname {string} and rownumber {int}")
	public void user_fills_the_form_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		ExcelReader exceldata = new ExcelReader();
		List<Map<String, String>>  testdata = exceldata.getData("C:\\Users\\kumar\\OneDrive\\Desktop/CucumberTest.xlsx", sheetName);

		String heading = testdata.get(rowNumber).get("subjectheding");
		String email = testdata.get(rowNumber).get("email");
		String orderef = testdata.get(rowNumber).get("orderref");
		String mesage = testdata.get(rowNumber).get("message");

		contactUsPage.fillContactUsForm(heading, email, orderef, mesage);


	}

	@When("user clicks on send button")
	public void user_clicks_on_send_button() {
		contactUsPage.clickSend();
	}

	@Then("it shows successfull message {string}")
	public void it_shows_successfull_message(String expectedMessage) {
		String actual =	contactUsPage.getSuccessMessage();
		Assert.assertEquals(actual, expectedMessage);
	}

}
