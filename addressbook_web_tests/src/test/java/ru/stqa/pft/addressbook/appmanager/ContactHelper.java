package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static org.testng.Assert.assertTrue;

public class ContactHelper extends HelperBase {

    private boolean acceptNextAlert = true;

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void returnToHomePage() {
      driver.findElement(By.linkText("home page")).click();
    }

    public void submitContactCreation() {
      driver.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    }

    public void fillContactForm(String firstname, String middlename, String lastname, String nickname, String title, String company, String address, String homephone, String bday, String bmonth, String byear) {
      type(By.name("firstname"), firstname);
      type(By.name("middlename"), middlename);
      type(By.name("lastname"), lastname);
      type(By.name("nickname"), nickname);
      type(By.name("title"), title);
      type(By.name("company"), company);
      type(By.name("address"), address);
      type(By.name("home"), homephone);
      selectData(By.name("bday"), bday);
      selectMonth(By.name("bmonth"), "January");
      type(By.name("byear"), byear);
      click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]"));
    }

    private void selectMonth(By locator, String text) {
        driver.findElement(locator).click();
        new Select(driver.findElement(locator)).selectByVisibleText(text);
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Birthday:'])[1]/following::option[35]"));
    }

    private void selectData(By locator, String text) {
        driver.findElement(locator).click();
        new Select(driver.findElement(locator)).selectByVisibleText(text);
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Birthday:'])[1]/following::option[17]"));
    }


    public void deleteSelectedContact() {
      acceptNextAlert = true;
      click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select all'])[1]/following::input[2]"));
      assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
    }

    public void selectContact() {
        driver.findElement(By.id("1")).click();
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

}
