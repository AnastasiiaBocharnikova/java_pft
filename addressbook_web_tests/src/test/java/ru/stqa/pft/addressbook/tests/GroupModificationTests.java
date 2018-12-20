package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.TestBase;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {
        applicationManager.getNavigationHelper().goToGroupPage();
        if (! applicationManager.getGroupHelper().isThereAGroup()) {
            applicationManager.getGroupHelper().createGroup(new GroupData("test11", null, null));
        }
        List<GroupData> before = applicationManager.getGroupHelper().getGroupList();
        applicationManager.getGroupHelper().selectGroup(before.size() - 1);
        applicationManager.getGroupHelper().initGroupModification();
        applicationManager.getGroupHelper().fillGroupForm(new GroupData("test11", "test22", "test33"));
        applicationManager.getGroupHelper().submitGroupModification();
        applicationManager.getGroupHelper().returnToGroupPage();
        List<GroupData> after = applicationManager.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());
    }
}
