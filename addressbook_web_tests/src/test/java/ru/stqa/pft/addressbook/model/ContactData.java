package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final String firstname;
    private final String middlename;
    private final String lastname;
    private final String nickname;
    private final String title;
    private final String company;
    private final String address;
    private final String homephone;
    private final String bday;
    private final String bmonth;
    private final String byear;
    private String group;

    public ContactData(String firstname, String middlename, String lastname, String nickname, String title, String company, String address, String homephone, String bday, String bmonth, String byear, String group) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.title = title;
        this.company = company;
        this.address = address;
        this.homephone = homephone;
        this.bday = bday;
        this.bmonth = bmonth;
        this.byear = byear;
        this.group = group;
    }

    public String getFirstname() {

        return firstname;
    }

    public String getMiddlename() {

        return middlename;
    }

    public String getLastname() {

        return lastname;
    }

    public String getNickname() {

        return nickname;
    }

    public String getTitle() {

        return title;
    }

    public String getCompany() {

        return company;
    }

    public String getAddress() {

        return address;
    }

    public String getHomephone() {

        return homephone;
    }

    public String getBday() {

        return bday;
    }

    public String getBmonth() {

        return bmonth;
    }

    public String getByear() {

        return byear;
    }

    public String getGroup() {
        return group;
    }
}
