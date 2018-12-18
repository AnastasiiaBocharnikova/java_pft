package ru.stqa.pft.addressbook.appmanager;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class TestBase {

    protected final ApplicationManager applicationManager = new ApplicationManager();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        applicationManager.init();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        applicationManager.stop();
    }

    public ApplicationManager getApplicationManager() {

        return applicationManager;
    }
}
