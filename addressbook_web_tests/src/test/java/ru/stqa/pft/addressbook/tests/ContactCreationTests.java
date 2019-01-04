package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.TestBase;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    Contacts before = applicationManager.contact().all();
    applicationManager.goTo().сontactPage();
    ContactData contact = new ContactData()
            .withFirstname("Testname").withMiddlename("TN").withLastname("TestLastName").withNickname("nick").withTitle("111").withCompany("company").withAddress("address")
            .withHomephone("1223").withMobile("1111").withWorkphone("22222").withBday("15").withEmail("qqqq@gmail.com").withEmail1("dftrg@gmail.com").withEmail2("frgf@gmail.com")
            .withBmonth("October").withByear("1992").withGroup("test11");
    applicationManager.contact().create(contact, true);
    assertThat(applicationManager.contact().count(), equalTo(before.size() + 1));
    Contacts after = applicationManager.contact().all();

//    int max = 0;
//    for (ContactData c : after) {
//      if (c.getId() > max) {
//        max = c.getId();
//      }
//    }

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

}
