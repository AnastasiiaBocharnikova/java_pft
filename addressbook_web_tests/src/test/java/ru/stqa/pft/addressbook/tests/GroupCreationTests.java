package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.appmanager.TestBase;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    applicationManager.getNavigationHelper().goToGroupPage();
    applicationManager.getGroupHelper().initGroupCreation();
    applicationManager.getGroupHelper().fillGroupForm(new GroupData("test11", null, null));
    applicationManager.getGroupHelper().submitGroupCreation();
    applicationManager.getGroupHelper().returnToGroupPage();
  }

}
