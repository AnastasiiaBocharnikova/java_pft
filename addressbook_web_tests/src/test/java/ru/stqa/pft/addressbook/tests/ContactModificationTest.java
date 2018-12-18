package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.TestBase;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModification(){
        applicationManager.getContactHelper().selectModificationContact();
        applicationManager.getContactHelper().submitContactEditForm();
        ContactData contactData = new ContactData("Testname", "TN", "TestLastName", "nick", "111", "company", "address", "000000000", "15", "October", "1992");
        applicationManager.getContactHelper().fillContactForm(contactData.getFirstname(), contactData.getMiddlename(), contactData.getLastname(), contactData.getNickname(), contactData.getTitle(), contactData.getCompany(), contactData.getAddress(), contactData.getHomephone());
        applicationManager.getContactHelper().submitContactModification();
        applicationManager.getContactHelper().returnToHomePage();
    }
}
