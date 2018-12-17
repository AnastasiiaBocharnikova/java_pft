package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.TestBase;

public class GroupDeletionTests extends TestBase {


  @Test
  public void testGroupDeletion() throws Exception {
    applicationManager.getNavigationHelper().goToGroupPage();
    applicationManager.getGroupHelper().selectGroup();
    applicationManager.getGroupHelper().deleteSelectedGroup();
    applicationManager.getGroupHelper().returnToGroupPage();
  }

}
