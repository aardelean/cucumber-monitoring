$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("f1.feature");
formatter.feature({
  "line": 1,
  "name": "the version can be retrieved",
  "description": "",
  "id": "the-version-can-be-retrieved",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 2,
  "name": "client makes call to GET /version",
  "description": "",
  "id": "the-version-can-be-retrieved;client-makes-call-to-get-/version",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 3,
  "name": "the client has server url",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "the client calls /version",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "the client receives status code of 200",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "the client receives server version 1.1",
  "keyword": "And "
});
formatter.match({
  "location": "VersionControllerTest.the_client_configures_url()"
});
formatter.result({
  "duration": 288150639,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "/version",
      "offset": 17
    }
  ],
  "location": "VersionControllerTest.the_client_issues_GET_version(String)"
});
formatter.result({
  "duration": 512706845,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 35
    }
  ],
  "location": "VersionControllerTest.the_client_receives_status_code_of(int)"
});
formatter.result({
  "duration": 17154294,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1.1",
      "offset": 35
    }
  ],
  "location": "VersionControllerTest.the_client_receives_server_version_body(String)"
});
formatter.result({
  "duration": 38603771,
  "error_message": "java.lang.AssertionError: 1 expectation failed.\nResponse body doesn\u0027t match expectation.\nExpected: a string containing \"1.1\"\n  Actual: 1.0\n\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\n\tat org.codehaus.groovy.reflection.CachedConstructor.invoke(CachedConstructor.java:83)\n\tat org.codehaus.groovy.reflection.CachedConstructor.doConstructorInvoke(CachedConstructor.java:77)\n\tat org.codehaus.groovy.runtime.callsite.ConstructorSite$ConstructorSiteNoUnwrap.callConstructor(ConstructorSite.java:84)\n\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCallConstructor(CallSiteArray.java:59)\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callConstructor(AbstractCallSite.java:238)\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callConstructor(AbstractCallSite.java:250)\n\tat io.restassured.internal.ResponseSpecificationImpl$HamcrestAssertionClosure.validate(ResponseSpecificationImpl.groovy:482)\n\tat io.restassured.internal.ResponseSpecificationImpl$HamcrestAssertionClosure$validate$1.call(Unknown Source)\n\tat io.restassured.internal.ResponseSpecificationImpl.validateResponseIfRequired(ResponseSpecificationImpl.groovy:654)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:498)\n\tat org.codehaus.groovy.runtime.callsite.PogoMetaMethodSite$PogoCachedMethodSiteNoUnwrapNoCoerce.invoke(PogoMetaMethodSite.java:210)\n\tat org.codehaus.groovy.runtime.callsite.PogoMetaMethodSite.callCurrent(PogoMetaMethodSite.java:59)\n\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCallCurrent(CallSiteArray.java:51)\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callCurrent(AbstractCallSite.java:157)\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callCurrent(AbstractCallSite.java:169)\n\tat io.restassured.internal.ResponseSpecificationImpl.content(ResponseSpecificationImpl.groovy:96)\n\tat io.restassured.specification.ResponseSpecification$content$1.callCurrent(Unknown Source)\n\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCallCurrent(CallSiteArray.java:51)\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callCurrent(AbstractCallSite.java:157)\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callCurrent(AbstractCallSite.java:177)\n\tat io.restassured.internal.ResponseSpecificationImpl.body(ResponseSpecificationImpl.groovy:255)\n\tat io.restassured.internal.ValidatableResponseOptionsImpl.body(ValidatableResponseOptionsImpl.java:268)\n\tat de.tetralog.v4wsmonitor.test.VersionControllerTest.the_client_receives_server_version_body(VersionControllerTest.java:44)\n\tat ✽.And the client receives server version 1.1(f1.feature:6)\n",
  "status": "failed"
});
formatter.uri("f2.feature");
formatter.feature({
  "line": 1,
  "name": "the version can be retrieved",
  "description": "",
  "id": "the-version-can-be-retrieved",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 2,
  "name": "client makes call to GET /version",
  "description": "",
  "id": "the-version-can-be-retrieved;client-makes-call-to-get-/version",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 3,
  "name": "the client has server url",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "the client calls /version",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "the client receives status code of 200",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "the client receives server version 1.0",
  "keyword": "And "
});
formatter.match({
  "location": "VersionControllerTest.the_client_configures_url()"
});
formatter.result({
  "duration": 649064,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "/version",
      "offset": 17
    }
  ],
  "location": "VersionControllerTest.the_client_issues_GET_version(String)"
});
formatter.result({
  "duration": 10319261,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 35
    }
  ],
  "location": "VersionControllerTest.the_client_receives_status_code_of(int)"
});
formatter.result({
  "duration": 315317,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1.0",
      "offset": 35
    }
  ],
  "location": "VersionControllerTest.the_client_receives_server_version_body(String)"
});
formatter.result({
  "duration": 738004,
  "status": "passed"
});
});