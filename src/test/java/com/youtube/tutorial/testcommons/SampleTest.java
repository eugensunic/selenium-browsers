package com.youtube.tutorial.testcommons;

import com.youtube.tutorial.SamplePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SampleTest {

    @BeforeAll
    public static void setOptions() {
        WebDriverSetup.setup();
    }

    @Test
    public void NavigateToLandingPageTest() {
        new SamplePage().NavigateToLandingPageAndOpenLogin();
    }

    @AfterAll
    public static void tearDown() {

    }
}
