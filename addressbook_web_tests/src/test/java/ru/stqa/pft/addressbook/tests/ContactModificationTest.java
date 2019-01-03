package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.TestBase;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (applicationManager.contact().all().size() == 0) {
            applicationManager.goTo().сontactPage();
            applicationManager.contact().create(new ContactData()
                    .withFirstname("Testname").withMiddlename("TN").withLastname("TestLastName").withNickname("nick")
                    .withTitle("111").withCompany("company").withAddress("address").withHomephone("000000000").withBday("15")
                    .withBmonth("October").withByear("1992").withGroup("test11"), true);
//            applicationManager.getContactHelper().returnToHomePage();
        }
    }

    @Test
    public void testContactModification(){
        Contacts before = applicationManager.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId()).withFirstname("Testname").withMiddlename("TN").withLastname("TestLastName").withNickname("nick")
                .withTitle("111").withCompany("company").withAddress("address").withHomephone("000000000").withBday("15").withBmonth("October").withByear("1992");
        applicationManager.contact().modify(contact);
        assertEquals(applicationManager.contact().count(), before.size() - 1);
        Contacts after = applicationManager.contact().all();
        assertThat(after, equalTo(before.without(modifiedContact)));
    }

}
