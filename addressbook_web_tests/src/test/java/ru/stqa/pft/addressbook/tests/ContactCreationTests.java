package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.appmanager.TestBase;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    applicationManager.getNavigationHelper().goToContactPage();
    ContactData contactData = new ContactData("Testname", null, "TestLastName", null, null, null, null, "000000000", "15", "October", "1992");
    applicationManager.getContactHelper().fillContactForm(contactData.getFirstname(), contactData.getMiddlename(), contactData.getLastname(), contactData.getNickname(), contactData.getTitle(), contactData.getCompany(), contactData.getAddress(), contactData.getHomephone());
    applicationManager.getContactHelper().submitContactCreation();
    applicationManager.getContactHelper().returnToHomePage();
  }

}
