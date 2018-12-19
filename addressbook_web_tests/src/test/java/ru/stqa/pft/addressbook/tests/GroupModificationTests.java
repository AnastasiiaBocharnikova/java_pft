package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.TestBase;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {
        applicationManager.getNavigationHelper().goToGroupPage();
        int before = applicationManager.getGroupHelper().getGroupCount();
        if (! applicationManager.getGroupHelper().isThereAGroup()) {
            applicationManager.getGroupHelper().createGroup(new GroupData("test11", null, null));
        }
        applicationManager.getGroupHelper().selectGroup(before - 1);
        applicationManager.getGroupHelper().initGroupModification();
        applicationManager.getGroupHelper().fillGroupForm(new GroupData("test11", "test22", "test33"));
        applicationManager.getGroupHelper().submitGroupModification();
        applicationManager.getGroupHelper().returnToGroupPage();
        int after = applicationManager.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before);
    }
}
