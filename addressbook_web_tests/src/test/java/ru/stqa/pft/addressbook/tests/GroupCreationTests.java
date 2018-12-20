package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.appmanager.TestBase;

import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    applicationManager.getNavigationHelper().goToGroupPage();
    List<GroupData> before = applicationManager.getGroupHelper().getGroupList();
    applicationManager.getGroupHelper().createGroup(new GroupData("test11", null, null));
    List<GroupData> after = applicationManager.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);
  }

}
