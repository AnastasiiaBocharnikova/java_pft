package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class AddContactTests extends TestBase {

  @Test
  public void testAddContact() throws Exception {
    app.getNavigationHelper().gotoContactPage();
    app.getContactHelper().fillContactForm(new ContactData("pppp", "rf", "rrrrr", "qwe", "jyujuun", "trgr", "fghbtt", "00000000", "1", "January", "1000"));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }

}