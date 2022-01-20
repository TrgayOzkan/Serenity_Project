package com.fortna.runner;


import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("API Test Suites")
@SelectPackages("com.fortna.rest")
@IncludeTags("smoke")
public class TestRunnerApi {
}
