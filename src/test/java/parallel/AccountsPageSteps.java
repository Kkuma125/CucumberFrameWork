package parallel;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.qa.factory.DriverFactory;
import com.qa.pages.AccountsPage;
import com.qa.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsPageSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;



	@Given("user has already logged in application")
	public void user_has_already_logged_in_application(DataTable dataTable) {

		List<Map<String,String>> credList = dataTable.asMaps();
		String userName = credList.get(0).get("username");
		String password = credList.get(0).get("password");

		DriverFactory.getDriver().get("http://automationpractice.pl/index.php?controller=authentication&back=my-account");
		accountsPage = loginPage.doLogin(userName, password);

	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		String title = accountsPage.getAccountsPageTitle();
		System.out.println(title);
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionsTable) {

		List<String> expectedList = sectionsTable.asList();
		System.out.println(expectedList);
		List<String> actualList = accountsPage.getAccountsSectionList();
		System.out.println(actualList);
		Assert.assertTrue(expectedList.containsAll(actualList));

	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer excpeted) {
		Assert.assertTrue(accountsPage.getAccountsSectionCount()== excpeted);
	}



}
