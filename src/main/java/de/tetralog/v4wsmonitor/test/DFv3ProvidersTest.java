package de.tetralog.v4wsmonitor.test;

import com.tetralog.datafeed3.service.iv0.dto.XmlDatafeedProviderDTO;
import com.tetralog.datafeed3.service.iv1.dto.GetDatafeedProvidersRequest;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import cucumber.runtime.java.StepDefAnnotation;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Java6Assertions.assertThat;


@StepDefAnnotation
public class DFv3ProvidersTest extends AbstractTestPropertiesAware {
    private DFv3Context context;

    public DFv3ProvidersTest(DFv3Context context) {
        super();
        this.context = context;
    }

    @When("^I submit the GetDatafeedProviders call$")
    public void i_submit_the_GetDatafeedProviders_call() throws Throwable {
        context.providersResponse = context.port.getDatafeedProviders(new GetDatafeedProvidersRequest());
    }

    @Then("^I should see the following datafeed providers in the xml response:$")
    public void i_should_see_the_following_datafeed_providers_in_the_xml_response(DataTable dataTable) throws Throwable {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        data.stream().forEach(this::verifyProvider);
    }

    private void verifyProvider(Map<String, String> providerExpectedValues) {
        String requestedId = providerExpectedValues.get("datafeedProvider:id");
        XmlDatafeedProviderDTO providerDTO = context.providersResponse.getDatafeedProviders().stream()
                .filter(p -> p.getId() == Long.valueOf(requestedId))
                .findFirst().orElseThrow(() -> new AssertionError("Could not find provider in the response with id :" + requestedId));
        assertThat(providerDTO.getDefaultLabel()).isEqualToIgnoringCase(providerExpectedValues.get("datafeedProvider:defaultLabel"));
        assertThat(providerDTO.getDomainKey()).isEqualToIgnoringCase(providerExpectedValues.get("datafeedProvider:domainKey"));
    }
}
