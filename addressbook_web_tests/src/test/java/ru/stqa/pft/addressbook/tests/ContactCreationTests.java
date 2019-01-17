package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.TestBase;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts() throws IOException {
    List<Object[]> list = new ArrayList<>();
    File photo = new File("src/test/resources/Screenshot_1.png");
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
    String line = reader.readLine();
    while (line != null) {
      String[] split = line.split(";");
      list.add(new Object[]{new ContactData().withFirstname(split[0]).withMiddlename(split[1]).withLastname(split[2]).withNickname(split[3]).withTitle(split[4]).withCompany(split[5])
              .withAddress(split[6]).withHomephone(split[7]).withMobile(split[8]).withWorkphone(split[9]).withBday(split[10]).withBmonth(split[11]).withByear(split[12]).withEmail(split[14])
              .withEmail1(split[15]).withEmail2(split[16]).withPhoto(photo).withGroup("test11")});
      line = reader.readLine();
    }
    return list.iterator();
  }


  @Test(dataProvider = "validContacts")
  public void testContactCreation(ContactData contact) {
    Contacts before = applicationManager.contact().all();
    applicationManager.goTo().сontactPage();
    applicationManager.contact().create(contact, true);
    assertThat(applicationManager.contact().count(), equalTo(before.size() + 1));
    Contacts after = applicationManager.contact().all();


    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

}
