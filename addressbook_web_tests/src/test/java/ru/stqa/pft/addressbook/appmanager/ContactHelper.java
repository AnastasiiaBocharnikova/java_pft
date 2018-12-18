package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

public class ContactHelper extends HelperBase {

    private boolean acceptNextAlert = true;

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void returnToHomePage() {

        click(By.linkText("home page"));
    }

    public void submitContactCreation() {

        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]"));
    }

    public void fillContactForm(String firstname, String middlename, String lastname, String nickname, String title, String company, String address, String homephone) {
      type(By.name("firstname"), firstname);
      type(By.name("middlename"), middlename);
      type(By.name("lastname"), lastname);
      type(By.name("nickname"), nickname);
      type(By.name("title"), title);
      type(By.name("company"), company);
      type(By.name("address"), address);
      type(By.name("home"), homephone);
    }

    public void deleteSelectedContact() {
      acceptNextAlert = true;
      click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select all'])[1]/following::input[2]"));
      assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
    }

    public void selectContact() {
       click(By.id("1"));
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    public void submitContactEditForm() {
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='address'])[4]/following::img[2]"));
    }

    public void submitContactModification() {
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]"));
    }

    public void selectModificationContact() {
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='import'])[1]/following::td[1]"));
    }
}
