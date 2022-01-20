package com.fortna.stepDef;

import com.fortna.pages.FortnaHomePage;
import com.fortna.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class FortnaSearchStepDef {

    FortnaHomePage homepage;
    @Given("user is at home page")
    public void user_is_at_home_page() {
        homepage = new FortnaHomePage();
        homepage.goTo();
    }
    @When("user search for keyword {string}")
    public void user_search_for_keyword(String keyword) {
        homepage.searchKeyword(keyword);
    }


    @Then("the title should start with {string}")
    public void the_title_should_start_with(String keyword) {
        //import static org.junit.Assert.assertTrue;
        assertTrue (Driver.getDriver().getTitle().contains(keyword));
    }


}
