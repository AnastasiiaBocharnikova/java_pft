package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;

public class TestDelete extends NewContactRef.TestBase {

  @Test
  public void testDelete() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().selectGroup();
    app.deleteSelectedGroups();
    app.getGroupHelper().returnToGropPage();
  }

}

