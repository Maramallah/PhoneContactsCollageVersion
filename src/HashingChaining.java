import java.util.Scanner;

public class HashingChaining {
    LinkedListPhones[] MyContacts ;
    static Scanner in = new Scanner(System.in);
    int size;

 HashingChaining(int size){
     this.size=size;
     MyContacts=new LinkedListPhones[size];
     for (int i = 0; i < MyContacts.length; i++) {
         MyContacts[i] = new LinkedListPhones();
     }
 }
    public  int HashFunction(String key) {
        int i, l = key.length();
        int hash = 0;
        for (i = 0; i < l; i++) {
            hash += Character.getNumericValue(key.charAt(i));
            hash += (hash << 10);
            hash ^= (hash >> 6);
        }
        hash += (hash << 3);
        hash ^= (hash >> 11);
        hash += (hash << 15);
        return (Math.abs(hash) % size);
    }
   void AddContact() {
        System.out.print("Enter contact name: ");
        String name = in.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = in.nextLine();
        int hash=HashFunction(name);
        MyContacts[hash].addContact(name,phoneNumber);
    }

    void DeleteContact() {
        System.out.print("Enter contact name to delete: ");
        String name = in.nextLine();
        int hash=HashFunction(name);
        MyContacts[hash].deleteontact(name);
    }

    void UpdateConatct() {
        System.out.print("Enter contact name to update: ");
        String name = in.nextLine();
        int hash=HashFunction(name);
        if (MyContacts[hash].searchContact(name)==null){
            System.out.println("The contact doesn`t exists");
        }else{
            System.out.print("Enter new phone number: ");
            String newPhoneNumber = in.nextLine();
            if( MyContacts[hash].updateContact(name,newPhoneNumber)){
                System.out.println("Contact " + name + " updated with new phone number " + newPhoneNumber + ".");
            }else{
                System.out.println("Error Updating");
            }

        }

    }

    void DisplayConatct() {
        System.out.println("Displaying all contacts...");
        for (int i=0;i<size;i++){
            if (MyContacts[i].GetSize()!=0){
                MyContacts[i].displayList();
            }
        }
    }

    void SearchConatct() {
        System.out.print("Enter contact name to search: ");
        String name = in.nextLine();
        System.out.println("Searching for contact " + name + "...");
        int hash=HashFunction(name);
        ContactNode node=  MyContacts[hash].searchContact(name);
        if (node!=null){
            System.out.println("Node Details ....");
            System.out.println(node.name+" ,"+ node.PhoneNumber);
        }else{
            System.out.println("Contact Not Found ");
        }


    }

}
