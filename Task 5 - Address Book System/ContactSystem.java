import java.io.IOException;
import java.util.Scanner;

public class ContactSystem {
    public static void main(String[] args) throws IOException {
        AddressBook ab = new AddressBook("contact_information.ser");
        Scanner input = new Scanner(System.in);


        while (true) {

            System.out.println("1:Add Contact to the Phone Book");
            System.out.println("2:Remove Contact to the Phone Book");
            System.out.println("3:Search Contact from the Phone Book");
            System.out.println("4:Display the All Contact Information");
            System.out.println("5:Edit Contact from the Phone Book");

            System.out.println("Select the Choice:");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter your name: ");
                    String name = input.nextLine();
                    System.out.println("Enter Your Contact No: ");
                    String phone = input.nextLine();
                    System.out.println("Enter Your Email Address: ");
                    String email = input.nextLine();

                    ab.addContact(new Contact(name, phone, email));
                    ab.saveDataFile();
                    break;

                case 2:
                    System.out.println("Enter your name: ");
                    String name1 = input.nextLine();
                    ab.removeContact(name1);
                    break;

                case 3:
                    System.out.println("Enter Your Name: ");
                    String name2 = input.nextLine();
                    System.out.println(ab.searchContact(name2));
                    break;

                case 4:
                    ab.displayAllContacts();
                    System.out.println();
                    break;

                case 5:
                    System.out.println("Enter Your Name: ");
                    String name3 = input.nextLine();
                    Contact editinfo = ab.searchContact(name3);
                    if(editinfo != null){
                        System.out.println("Enter your New Name: ");
                        String newName = input.nextLine();
                        System.out.println("Enter Your New Contact No: ");
                        String newPhone = input.nextLine();
                        System.out.println("Enter Your New Email Address: ");
                        String newEmail = input.nextLine();

                        editinfo.setName(newName);
                        editinfo.setPhoneNo(newPhone);
                        editinfo.setEmail(newEmail);
                    }else{
                        System.out.println("Contact Not Found......");
                    }
                    break;

                default:
                    System.out.println("Invalid Choice.....");
            }
        }


    }
}
