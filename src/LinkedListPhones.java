import java.util.Objects;

public class LinkedListPhones {
    ContactNode Head=null;
    int size=0;

     void addContact(String name,String PhoneNumber){
      ContactNode newNode= new ContactNode(name,PhoneNumber);
      if (Head==null){
        Head=newNode;
          System.out.print("Node Added successfully  : ");
          System.out.println("name: " + Head.name+" , Phone :  "+Head.PhoneNumber);
      }else{
          ContactNode current=Head;
          while(current.next!=null){
              current=current.next;
          }
          current.next=newNode;
          System.out.print("Node Added successfully ");
          System.out.println("name: " + current.name+" , Phone :  "+current.PhoneNumber);

      }
      size++;

    }

     void displayList(){
         if (Head==null){
             System.out.println("The phone list is Empty");
         }else{
             ContactNode current=Head;
             while(current!=null){
                 System.out.println("name: " + current.name+" , Phone :  "+current.PhoneNumber);
                 current=current.next;
             }


         }

    }
     ContactNode searchContact(String name){
         if (Head==null){
             System.out.println("The phone list is Empty");
         }else{

             ContactNode current=Head;
             while(current!=null){
                if (Objects.equals(current.name, name)){
                    return current;
                }
                current=current.next;
             }

         }
         return null;

    }
     void deleteontact(String name){

         if (Head==null){
             System.out.println("The phone list is Empty");
         }else{

             if (Head.name.equals(name)){

                 System.out.print("Node deleted successfully ");
                 System.out.println("name: " + Head.name+" , Phone :  "+Head.PhoneNumber);
                 Head=Head.next;
                 size--;
                 return;
             }

             ContactNode current=Head;
             ContactNode Prev=null;
             while(current!=null){

                if(current.name.equals(name)){
                    Prev.next=current.next;
                    current.next=null;

                    System.out.println("Node deleted successfully ");
                    System.out.println("name: " + current.name+" , Phone :  "+current.PhoneNumber);
                    size--;
                    return;
                }
                 Prev=current;
                 current=current.next;

             }
             System.out.println("contact "+name+" dosen`t exists to Delete");


         }

    }
    boolean updateContact (String name, String newPhone){
         if (searchContact(name)!=null){
             ContactNode n = searchContact(name);
             n.PhoneNumber=newPhone;
             return true;
         }else{
             return false;
         }
    }
    int GetSize(){
         return size;
    }

}
