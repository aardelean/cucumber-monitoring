package de.tetralog.v4wsmonitor.test;

import com.tetralog.datafeed3.service.iv1.Datafeed3Service;
import com.tetralog.datafeed3.service.iv1.Datafeed3ServiceException;
import com.tetralog.datafeed3.service.iv1.Datafeed3ServicePortType;
import com.tetralog.datafeed3.service.iv1.dto.GetDatafeedProvidersRequest;
import com.tetralog.datafeed3.service.iv1.dto.GetVersionRequest;
import com.tetralog.datafeed3.service.iv1.dto.GetVersionResponse;
import cucumber.api.java.en.Given;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import java.net.URL;
import java.util.Map;

public class DFv3SoapRequestStep extends AbstractTestPropertiesAware {
    public static final String WSDL_LOCATION = "META-INF/Datafeed3Service-IV1.wsdl";
    public static final QName SERVICE_NAME = new QName("http://www.tetralog.com/datafeed3/service/iv1", "Datafeed3Service");
    private DFv3Context context;
    private String subpath;

    public DFv3SoapRequestStep(DFv3Context context) {
        super();
        subpath = get("dfv3.service.by.client");
        this.context = context;
    }

    @Given("^I want to use DFv4 instance \"([^\"]*)\" via the v3 interface using endpoint \"([^\"]*)\"$")
    public void i_want_to_use_DFv_instance_via_the_v_interface_using_endpoint(String env, String endpoint) throws Datafeed3ServiceException {

        URL wsdlUrl = getClass().getClassLoader().getResource(WSDL_LOCATION);
        Datafeed3Service service = new Datafeed3Service(wsdlUrl, SERVICE_NAME);
        Datafeed3ServicePortType port = service.getPort(Datafeed3ServicePortType.class);

        BindingProvider bindingProvider = (BindingProvider) port;
        Map<String, Object> requestContext = bindingProvider.getRequestContext();

        requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, get(env) + String.format(subpath, endpoint));
        requestContext.put(BindingProvider.USERNAME_PROPERTY, getDefaultUser());
        requestContext.put(BindingProvider.PASSWORD_PROPERTY, getDefaultPass());

//        GetVersionResponse response = port.getVersion(new GetVersionRequest());
//        port.getDatafeedProviders(new GetDatafeedProvidersRequest());
        context.port = port;
    }
}
