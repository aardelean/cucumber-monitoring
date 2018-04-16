package de.tetralog.v4wsmonitor.test;

import cucumber.api.java.en.Given;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.XmlConfig;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class DFv3Test extends AbstractTestPropertiesAware {
    protected String subpath;
    private DFv4Context context;

    public DFv3Test(DFv4Context context) {
        super();
        subpath = get("dfv3.service.by.client");
        this.context = context;
    }

//    @Given("^I want to use DFv4 instance \"([^\"]*)\" via the v3 interface using endpoint \"([^\"]*)\"$")
//    public void i_want_to_use_DFv_instance_via_the_v_interface_using_endpoint(String env, String endpoint) throws Throwable {
//        context.requestSpecification = given()
//                .config(RestAssuredConfig.config().xmlConfig(XmlConfig.xmlConfig().with().namespaceAware(true)))
//                .baseUri(get(env) + String.format(subpath, endpoint))
//                .auth().basic(getDefaultUser(), getDefaultPass())
//                .accept(ContentType.XML);
//    }
}
