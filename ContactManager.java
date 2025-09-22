import java.util.*;

class Contact {
    String name;
    String phone;
    String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public void display() {
        System.out.println("Name : " + name);
        System.out.println("Phone : " + phone);
        System.out.println("Email : " + email);
        System.out.println("-----------------------");
    }
}

public class ContactManager {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Contact> contactList = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Contact Management System ---");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact by Name");
            System.out.println("4. Update Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    updateContact();
                    break;
                case 5:
                    deleteContact();
                    break;
                case 6:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 6);
    }

    static void addContact() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        contactList.add(new Contact(name, phone, email));
        System.out.println("Contact added successfully!");
    }

    static void viewContacts() {
        if (contactList.isEmpty()) {
            System.out.println("No contacts to display.");
            return;
        }
        for (Contact c : contactList) {
            c.display();
        }
    }

    static void searchContact() {
        System.out.print("Enter name to search: ");
        String name = sc.nextLine();
        boolean found = false;

        for (Contact c : contactList) {
            if (c.name.equalsIgnoreCase(name)) {
                c.display();
                found = true;
            }
        }

        if (!found)
            System.out.println("Contact not found.");
    }

    static void updateContact() {
        System.out.print("Enter name of the contact to update: ");
        String name = sc.nextLine();
        for (Contact c : contactList) {
            if (c.name.equalsIgnoreCase(name)) {
                System.out.print("Enter new Phone: ");
                c.phone = sc.nextLine();
                System.out.print("Enter new Email: ");
                c.email = sc.nextLine();
                System.out.println("Contact updated successfully!");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    static void deleteContact() {
        System.out.print("Enter name of the contact to delete: ");
        String name = sc.nextLine();
        Iterator<Contact> itr = contactList.iterator();
        while (itr.hasNext()) {
            Contact c = itr.next();
            if (c.name.equalsIgnoreCase(name)) {
                itr.remove();
                System.out.println("Contact deleted successfully!");
                return;
            }
        }
        System.out.println("Contact not found.");
    }
}
