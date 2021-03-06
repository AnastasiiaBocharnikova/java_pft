package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

    @Parameter(names = "-c", description = "Contact count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    public static void main(String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<ContactData> contacts = generateContacts(count);
        save(contacts, new File(file));
    }

    private static void save(List<ContactData> contacts, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (ContactData contact : contacts) {
            writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n", contact.getFirstname(), contact.getMiddlename(), contact.getLastname(), contact.getNickname(), contact.getTitle(), contact.getCompany(), contact.getAddress(),
                    contact.getHomephone(), contact.getMobile(), contact.getWorkphone(), contact.getBday(), contact.getBmonth(), contact.getByear(), contact.getEmail(), contact.getEmail1(), contact.getEmail2()));
        }
        writer.close();
    }

    private static List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            contacts.add(new ContactData().withFirstname(String.format("first name %s", i)).withMiddlename(String.format("middle name %s", i)).withLastname(String.format("last name %s", i)).withNickname(String.format("nick name %s", i))
                    .withTitle(String.format("titlr %s", i)).withCompany(String.format("company %s", i)).withAddress(String.format("address %s", i)).withHomephone(String.format("home phone %s", i)).withMobile(String.format("mobile %s", i)).withWorkphone(String.format("workphone %s", i))
                    .withBday(String.format("b-day %s", i)).withBmonth(String.format("b-month %s", i)).withByear(String.format("b-year %s", i)).withEmail(String.format("email %s", i)).withEmail1(String.format("email1 %s", i)).withEmail2(String.format("email2%s", i)));
        }
        return contacts;
    }
}
