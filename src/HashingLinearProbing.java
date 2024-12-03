import java.util.Scanner;

public class HashingLinearProbing {
     Scanner in = new Scanner(System.in);
    ContactNodeForProbing arr[];
    int size=0;
    int capacity=0;


    HashingLinearProbing(int size){
        arr=new ContactNodeForProbing [size];
        this.size=size;
    }


    void AddContact(){
        System.out.print("Enter contact name: ");
        String name = in.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = in.nextLine();
        _Insert(name,phoneNumber);

    }
    void DeleteContact(){
        System.out.print("Enter contact name: ");
        String name = in.nextLine();
      if(_DeleteWithFlag(name)) {
          System.out.println("Node Deleted successfully");
      }else{
          System.out.println("contact doesn`t exists");
      }
    }
    void UpdateConatct(){
        System.out.print("Enter contact name: ");
        String name = in.nextLine();
        int node=_Search(name);
        if (node!=-1){
            System.out.println("Enter New Number :");
            String phoneNumber = in.nextLine();
            arr[node].PhoneNumber=phoneNumber;
            System.out.println("Node Updated Successfully : ");
            System.out.println(arr[node].Name +" , "+arr[node].PhoneNumber);

        }else{
            System.out.println("Contact Doesn`t Exist");
        }
    }
    void SearchContact(){
        System.out.print("Enter contact name: ");
        String name = in.nextLine();
        int node=_Search(name);
        if (node!=-1){
            System.out.println("Contact Found ");
            System.out.println(arr[node].Name +" , "+arr[node].PhoneNumber);

        }else{
            System.out.println("Contact Doesn`t Exist");
        }

    }
    void Display (){
        for(int i=0 ;i<size;i++){
            if(arr[i]==null || arr[i].occubiedBefor==true){
                continue;
            }
            System.out.println(arr[i].Name +" , "+arr[i].PhoneNumber);
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

 private    void _Insert (String name, String phoneNumber){
        int index= HashFunction(name);
            while(arr[index]!=null || (arr[index]!=null && arr[index].occubiedBefor!= false) ){
                index=(index+1)%size;
            }
            ContactNodeForProbing NewConatct=new ContactNodeForProbing(name,phoneNumber,false);
            arr[index]=NewConatct;

    }

    private int _Search(String key){
        int index=HashFunction(key);
        while(arr[index]!=null){
            if (arr[index].Name.equals(key)&& arr[index].occubiedBefor==false){
                return index;
            }
            index=(index+1)%size;
        }
      return -1;
    }
    private  boolean _DeleteWithFlag (String key){
        int node=_Search(key);
        if (node!=-1){
            arr[node].occubiedBefor=true;
            return true;
        }else{

            return false;
        }
    }




}
