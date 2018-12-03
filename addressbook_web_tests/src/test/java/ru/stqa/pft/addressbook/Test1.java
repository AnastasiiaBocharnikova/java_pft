package ru.stqa.pft.addressbook;

import org.testng.annotations.*;

public class Test1 extends TestBase {

  @Test
  public void test1() throws Exception {
    goToGroupPage();
    initGoupCreation();
    fillGrupForm("Tesr4", "qqqq", "qqqq");
    submitGroupCreation();
    returnToGropPage();
    }

}
