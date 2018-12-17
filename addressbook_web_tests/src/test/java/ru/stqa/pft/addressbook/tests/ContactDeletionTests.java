package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.TestBase;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {
    applicationManager.getContactHelper().selectContact();
    applicationManager.getContactHelper().deleteSelectedContact();
  }

}
