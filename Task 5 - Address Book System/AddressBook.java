import java.io.*;
import java.util.ArrayList;

public class AddressBook {
    private ArrayList<Contact> contacts;
    private File dfile;
    public AddressBook(String file) {
        contacts = new ArrayList<>();
        dfile =new File(file);

        if(dfile.exists()) {
            try {
                readFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("File Not Found.....");
        }
    }
    //add Contact
    public void addContact(Contact contact){
        contacts.add(contact);
    }

    //remove Contact
    public void removeContact(String name){
        Contact removeContact = null;
        for (Contact contact : contacts){
            if(contact.getName() != null && contact.getName().equals(name)){
                removeContact = contact;
            }
        }

        if (removeContact != null) {
            contacts.remove(removeContact);
            System.out.println("Contact removed successfully.");
        } else {
            System.out.println("Contact not found.");
        }

    }

    //search contact
    public Contact searchContact(String name){
        for(Contact contact:contacts){
            if(contact.getName() != null && contact.getName().equals(name)){
                return contact;
            }
        }
       return null;
    }

    //display all contacts
    public void displayAllContacts(){
        for(Contact contact:contacts){
            System.out.println(contact);
        }
    }

    //store contacts in the external file
    public void saveDataFile() throws IOException {

            FileOutputStream os = new FileOutputStream(dfile);
            ObjectOutputStream objout = new ObjectOutputStream(os);
            objout.writeObject(contacts);

        }

    //read contacts from external file
    @SuppressWarnings("unchecked")
    private void readFile() throws IOException, ClassNotFoundException {
        FileInputStream input = new FileInputStream(dfile);
        ObjectInputStream objin = new ObjectInputStream(input);
        contacts = (ArrayList<Contact>)objin.readObject();
    }



    }



