package ru.stqa.pft.addressbook.model;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.tests.NewContactRef;

public class Test1 extends NewContactRef.TestBase {

  @Test
  public void test1() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().initGoupCreation();
    app.getGroupHelper().fillGrupForm("Tesr4", "qqqq", "qqqq");
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGropPage();
    }

}
