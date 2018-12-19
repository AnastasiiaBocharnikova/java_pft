package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.TestBase;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModification(){
        int before = applicationManager.getContactHelper().getContactCount();
        if (! applicationManager.getContactHelper().isThereAContact()) {
            applicationManager.getNavigationHelper().goToContactPage();
            applicationManager.getContactHelper().createContact(new ContactData("Testname", "TN", "TestLastName", "nick", "111", "company", "address", "000000000", "15", "October", "1992", "test11"), true);
            applicationManager.getContactHelper().returnToHomePage();
        }
        applicationManager.getContactHelper().selectModificationContact(before - 1);
        applicationManager.getContactHelper().fillContactForm(new ContactData("Testname", "TN", "TestLastName", "nick", "111", "company", "address", "000000000", "15", "October", "1992", null), false);
        applicationManager.getContactHelper().submitContactModification();
        applicationManager.getContactHelper().returnToHomePage();
        int after = applicationManager.getContactHelper().getContactCount();
        Assert.assertEquals(after, before - 1);
    }
}
