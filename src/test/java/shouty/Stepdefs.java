package shouty;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Before;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class Stepdefs {

    private Person sean;
    private Person lucy;
    private String messageFromSean;
    private Network network;

    @Before
    public void createNetwork() {
        network = new Network();
    }

    @Given("^a person named Lucy$")
    public void a_person_named_Lucy() throws Throwable {
        lucy = new Person(network);
    }

    @Given("^a person named Sean$")
    public void a_person_named_Sean() throws Throwable {
        sean = new Person(network);
    }

    @When("^Sean shouts \"(.*?)\"$")
    public void sean_shouts(String message) throws Throwable {
        sean.shout(message);
        messageFromSean = message;
    }

    @Then("^Lucy hears Sean's message$")
    public void lucy_hears_Sean_s_message() throws Throwable {
        assertEquals(asList(messageFromSean), lucy.getMessagesHeard());
    }
}
