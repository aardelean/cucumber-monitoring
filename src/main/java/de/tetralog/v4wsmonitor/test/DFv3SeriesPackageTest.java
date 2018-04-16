package de.tetralog.v4wsmonitor.test;

import com.tetralog.datafeed3.service.iv0.dto.XmlQuoteSeriesPackageDTO;
import com.tetralog.datafeed3.service.iv1.dto.GetQuoteSeriesPackagesRequest;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.StepDefAnnotation;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Java6Assertions.assertThat;

@StepDefAnnotation
public class DFv3SeriesPackageTest extends AbstractTestPropertiesAware {
    private DFv3Context context;

    public DFv3SeriesPackageTest(DFv3Context context) {
        super();
        this.context = context;
    }

    @When("^I submit the GetQuoteSeriesPackages call$")
    public void i_submit_the_GetQuoteSeriesPackages_call() throws Throwable {
        context.quoteSeriesPackagesResponse = context.port.getQuoteSeriesPackages(new GetQuoteSeriesPackagesRequest());
    }

    @Then("^I should see the following quoteseries packages in the xml response:$")
    public void i_should_see_the_following_quoteseries_packages_in_the_xml_response(DataTable dataTable) throws Throwable {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        data.stream().forEach(this::verifyProvider);
    }

    private void verifyProvider(Map<String, String> providerExpectedValues) {
        String requestedId = providerExpectedValues.get("quoteSeriesPackage:id");
        XmlQuoteSeriesPackageDTO quoteDTO = context.quoteSeriesPackagesResponse.getQuoteSeriesPackages().stream()
                .filter(p -> p.getId() == Long.valueOf(requestedId))
                .findFirst().orElseThrow(() -> new AssertionError("Could not find provider in the response with id :" + requestedId));
        assertThat(quoteDTO.getDefaultLabel()).isEqualToIgnoringCase(providerExpectedValues.get("quoteSeriesPackage:defaultLabel"));
        assertThat(quoteDTO.getDomainKey()).isEqualToIgnoringCase(providerExpectedValues.get("quoteSeriesPackage:domainKey"));
    }
}
