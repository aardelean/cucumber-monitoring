package de.tetralog.v4wsmonitor.test;

import com.tetralog.datafeed3.service.iv1.Datafeed3ServicePortType;
import com.tetralog.datafeed3.service.iv1.dto.GetDatafeedProvidersResponse;
import com.tetralog.datafeed3.service.iv1.dto.GetQuoteSeriesPackagesResponse;

public class DFv3Context {
    Datafeed3ServicePortType port;
    GetDatafeedProvidersResponse providersResponse;
    GetQuoteSeriesPackagesResponse quoteSeriesPackagesResponse;
}
