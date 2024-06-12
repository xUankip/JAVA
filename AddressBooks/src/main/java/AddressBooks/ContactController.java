package AddressBooks;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactController {
    ArrayList<Contact> contacts = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);
    public void create(){
        System.out.println("Enter Name");
        String name = scanner.nextLine();
        System.out.println("Enter Company");
        String company = scanner.nextLine();
        System.out.println("Enter Email");
        String email = scanner.nextLine();
        System.out.println("Enter Phone");
        String phone = scanner.nextLine();
        Contact contact = new Contact(name, company, email, phone);
        contacts.add(contact);
        System.out.println("Create Success");
    }

    public void findByName() {
        System.out.println("Enter the contact name:");
        String name = scanner.nextLine();
        for (Contact contact : contacts) {
            if (name.equalsIgnoreCase(contact.getName())) {
                System.out.printf("%s - %s - %s" + name, contact.getCompany(), contact.getEmail(), contact.getPhone());
                break;
            } else {
                System.out.println("Not Found");
            }
        }
    }

    public void findAll() {
        System.out.println("All Contact List");
        for (Contact contact : contacts){
            System.out.println(contact);
        }
    }
}
