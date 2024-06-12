package AddressBooks;

import java.util.Scanner;

public class AddressBooks {
    public static void main(String[] args) {
        ContactController controller = new ContactController();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Main Menu");
            System.out.println("_____________________________________");
            System.out.println("1.Add new Contact");
            System.out.println("2.Find Contact By Name");
            System.out.println("3.Show All Contacts");
            System.out.println("4.Exit");
            System.out.println("______________________________________");
            System.out.println("Choose the number form 1-4");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    controller.create();
                    break;
                case 2:
                    controller.findByName();
                    break;
                case 3:
                    controller.findAll();
                    break;
                case 4:
                    System.out.println("Closing Program");
                    System.exit(1);
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }
}
