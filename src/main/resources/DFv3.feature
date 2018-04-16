Feature: Test DFv4 v3 interface calls


# How to access the datafeed for a "specific customer":
# With the native v4 interface the proper configuration may be selected via a client id ("fiducia", "fiducia-test")
# With the v3ws interface, the proper configuration may be selected via an endpoint ID ("jyske", "test", etc)
# Compare configurations in de.tetralog.fad.ted.enpl\ted.enpl.v4ws\ted.enpl.v4ws.core\src\main\resources\v4ws-client-config
# vs                        de.tetralog.fad.ted.enpl\ted.enpl.v3ws\ted.enpl.v3ws.impl\src\main\resources\v3ws-endpoints
# Example v4: Given I want to use DFv4 instance "prod" via the v4 interface using client id "fiducia-test"
# Example v3: Given I want to use DFv4 instance "prod" via the v3 interface using endpoint "jyske"





  @quickcheck
  Scenario: Test GetDatafeedProviders call
    Given I want to use DFv4 instance "prod" via the v3 interface using endpoint "jyske"
    When I submit the GetDatafeedProviders call
    Then I should see the following datafeed providers in the xml response:
      | datafeedProvider:id | datafeedProvider:domainKey| datafeedProvider:defaultLabel |
      |                  12 |                     jyske |                    Jyske Bank |
      |                  17 |                     pqaba |           Bank Austria by PQA |



  @quickcheck
  Scenario: Test GetQuoteSeriesPackages call
    Given I want to use DFv4 instance "prod" via the v3 interface using endpoint "jyske"
    When I submit the GetQuoteSeriesPackages call
    Then I should see the following quoteseries packages in the xml response:
      | quoteSeriesPackage:id | quoteSeriesPackage:domainKey| quoteSeriesPackage:defaultLabel |
      |                     1 |                       jyske |                           jyske |

