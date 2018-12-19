package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.TestBase;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {
    int before = applicationManager.getContactHelper().getContactCount();
    if (! applicationManager.getContactHelper().isThereAContact()) {
      applicationManager.getNavigationHelper().goToContactPage();
      applicationManager.getContactHelper().createContact(new ContactData("Testname", "TN", "TestLastName", "nick", "111", "company", "address", "000000000", "15", "October", "1992", "test11"), true);
    }
    applicationManager.getContactHelper().selectContact(before - 1);
    applicationManager.getContactHelper().deleteSelectedContact();
    int after = applicationManager.getContactHelper().getContactCount();
    Assert.assertEquals(after, before - 1);
  }

}
