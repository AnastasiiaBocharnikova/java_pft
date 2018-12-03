package ru.stqa.pft.addressbook;

import org.testng.annotations.*;

public class TestDelete extends TestBase {

  @Test
  public void testDelete() throws Exception {
    goToGroupPage();
    selectGroup();
    deleteSelectedGroups();
    returnToGropPage();
  }

}

