package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.TestBase;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {
    if (! applicationManager.getContactHelper().isThereAContact()) {
      applicationManager.getNavigationHelper().goToContactPage();
      applicationManager.getContactHelper().createContact(new ContactData("Testname", "TN", "TestLastName", "nick", "111", "company", "address", "000000000", "15", "October", "1992", "test11"), true);
    }
    List<ContactData> before = applicationManager.getContactHelper().getContactList();
    applicationManager.getContactHelper().selectContact(before.size() - 1);
    applicationManager.getContactHelper().deleteSelectedContact();
    List<ContactData> after = applicationManager.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }

}
