package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.TestBase;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        applicationManager.goTo().groupPage();
        if (applicationManager.group().all().size() == 0) {
            applicationManager.group().create(new GroupData().withName("test11"));
        }
    }

    @Test
    public void testGroupModification() {
        Groups before = applicationManager.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId()).withName("test11").withHeader("test22").withFooter("test33");
        applicationManager.group().modify(group);
        assertEquals(applicationManager.group().count(), before.size());
        Groups after = applicationManager.group().all();
        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
    }
}
