package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper extends HelperBase{

    public GroupHelper(WebDriver driver) {
        super(driver);
    }

    public void returnToGropPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
       click(By.name("submit"));
    }

    public void fillGrupForm(String name, String header, String footer) {
       type(By.name("group_name"), name);
       type(By.name("group_header"), header);
       type(By.name("group_footer"), footer);
    }

    public void initGoupCreation() {
        click(By.name("new"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }
}
