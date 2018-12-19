package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.TestBase;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {


  @Test
  public void testGroupDeletion() throws Exception {
    applicationManager.getNavigationHelper().goToGroupPage();
    int before = applicationManager.getGroupHelper().getGroupCount();
    if (! applicationManager.getGroupHelper().isThereAGroup()) {
      applicationManager.getGroupHelper().createGroup(new GroupData("test11", null, null));
    }
    applicationManager.getGroupHelper().selectGroup(before - 1);
    applicationManager.getGroupHelper().deleteSelectedGroup();
    applicationManager.getGroupHelper().returnToGroupPage();
    int after = applicationManager.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before - 1);
  }

}
