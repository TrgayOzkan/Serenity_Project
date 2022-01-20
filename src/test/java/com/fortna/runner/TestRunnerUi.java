package com.fortna.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(  features = "src/test/resources/featureFiles" ,
        glue = "com/fortna/stepDef" ,
        publish = true,
        plugin = {"pretty", "html:target/cucumber.html" ,
                "rerun:target/rerun.txt" ,
                "me.jvt.cucumber.report.PrettyReports:target"
        } ,
        dryRun = false
            , tags = "@ui"
)
public class TestRunnerUi {
}
