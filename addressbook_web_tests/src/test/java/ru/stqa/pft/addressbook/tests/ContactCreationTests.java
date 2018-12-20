package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.appmanager.TestBase;

import java.util.List;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    List<ContactData> before = applicationManager.getContactHelper().getContactList();
    applicationManager.getNavigationHelper().goToContactPage();
    applicationManager.getContactHelper().createContact(new ContactData("Testname", "TN", "TestLastName", "nick", "111", "company", "address", "000000000", "15", "October", "1992", "test11"), true);
    List<ContactData> after = applicationManager.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);
  }

}
