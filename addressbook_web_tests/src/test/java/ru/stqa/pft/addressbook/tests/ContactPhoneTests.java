package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.TestBase;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (applicationManager.contact().all().size() == 0) {
            applicationManager.goTo().сontactPage();
            applicationManager.contact().create(new ContactData()
                    .withFirstname("Testname").withMiddlename("TN").withLastname("TestLastName").withNickname("nick")
                    .withTitle("111").withCompany("company").withAddress("address").withHomephone("0000").withMobile("1111").withWorkphone("22222")
                    .withBday("15").withBmonth("October").withByear("1992").withGroup("test11"), true);
        }
    }

    @Test
    public void testContactPhones() {
        applicationManager.goTo().goToHomePage();
        ContactData contact = applicationManager.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = applicationManager.contact().infoFromEditForm(contact);

        assertThat(contact.getHomephone(), equalTo(contactInfoFromEditForm.getHomephone()));
        assertThat(contact.getMobile(), equalTo(contactInfoFromEditForm.getMobile()));
        assertThat(contact.getWorkphone(), equalTo(contactInfoFromEditForm.getWorkphone()));
    }

}
