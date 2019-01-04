package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.TestBase;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (applicationManager.contact().all().size() == 0) {
            applicationManager.goTo().сontactPage();
            applicationManager.contact().create(new ContactData()
                    .withFirstname("Testname").withMiddlename("TN").withLastname("TestLastName").withNickname("nick").withTitle("111").withCompany("company").withAddress("address")
                    .withHomephone("+1223").withMobile("11-11").withWorkphone("22 222").withEmail("qqqq@gmail.com").withEmail1("dftrg@gmail.com").withEmail2("frgf@gmail.com")
                    .withBday("15").withBmonth("October").withByear("1992").withGroup("test11"), true);
        }
    }

    @Test
    public void testContactEmail() {
        applicationManager.goTo().goToHomePage();
        ContactData contact = applicationManager.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = applicationManager.contact().infoFromEditForm(contact);

        assertThat(contact.getEmail(), equalTo(cleaned(contactInfoFromEditForm.getEmail())));
        assertThat(contact.getEmail1(), equalTo(cleaned(contactInfoFromEditForm.getEmail1())));
        assertThat(contact.getEmail2(), equalTo(cleaned(contactInfoFromEditForm.getEmail2())));
    }

    public String cleaned(String email) {
        return email.replaceAll("\\s", "").replaceAll("-()", "");
    }
}
