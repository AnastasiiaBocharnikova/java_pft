package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.appmanager.TestBase;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    int before = applicationManager.getContactHelper().getContactCount();
    applicationManager.getNavigationHelper().goToContactPage();
    applicationManager.getContactHelper().createContact(new ContactData("Testname", "TN", "TestLastName", "nick", "111", "company", "address", "000000000", "15", "October", "1992", "test11"), true);
    int after = applicationManager.getContactHelper().getContactCount();
    Assert.assertEquals(after, before + 1);
  }

}
