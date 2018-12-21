package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.TestBase;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    List<ContactData> before = applicationManager.getContactHelper().getContactList();
    applicationManager.getNavigationHelper().goToContactPage();
    ContactData contact = new ContactData("Testname", "TN", "TestLastName", "nick", "111", "company", "address", "000000000", "15", "October", "1992", "test11");
    applicationManager.getContactHelper().createContact(contact, true);
    List<ContactData> after = applicationManager.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    int max = 0;
    for (ContactData g : after) {
      if (g.getId() > max) {
        max = g.getId();
      }
    }
    contact.setId(max);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}
