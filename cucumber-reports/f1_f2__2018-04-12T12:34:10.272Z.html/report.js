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
  "duration": 324536108,
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
  "duration": 497741034,
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
  "duration": 20661718,
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
