import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
        HashingChaining MyChaining =new HashingChaining(1009);
        HashingLinearProbing MyChaining2=new HashingLinearProbing(1009);
        int choice = 0;

        do {
            System.out.println(" 1  Add contact ");
            System.out.println(" 2 Delete contact ");
            System.out.println(" 3 Display contacts ");
            System.out.println(" 4 Update contact ");
            System.out.println(" 5 Search contact ");
            System.out.println(" 6 Exit ");
            System.out.print("Enter Your Choice : ");
            choice = in.nextInt();

            switch (choice) {
                case 1:
                   // MyChaining.AddContact();
                    MyChaining2.AddContact();
                    break;
                case 2:
                   // MyChaining.DeleteContact();
                    MyChaining2.DeleteContact();
                    break;
                case 3:
                    //MyChaining.DisplayConatct();
                    MyChaining2.Display();
                    break;
                case 4:
                   // MyChaining.UpdateConatct();
                    MyChaining2.UpdateConatct();
                    break;
                case 5:
                   // MyChaining.SearchConatct();
                    MyChaining2.SearchContact();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }

        } while (choice != 6);
    }








}
