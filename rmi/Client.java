package experiment05_rmi;

//4. Client.java

import java.rmi.Naming;
import java.util.Scanner;

public class Client {
 public static void main(String[] args) {
     try {
         PalindromeI obj = (PalindromeI) Naming.lookup("rmi://localhost:5000/PALINDROME");
         Scanner scanner = new Scanner(System.in);
         char choice;

         do {
             System.out.println("Operation Menu");
             System.out.println("1. String Palindrome.");
             System.out.println("2. Number Palindrome.");
             int type = scanner.nextInt();
             scanner.nextLine();

             System.out.println("Enter the input:");
             String input = scanner.nextLine();

             boolean result = obj.isPalindrome(input, type);
             if (result) {
                 System.out.println("It is a palindrome.");
             } else {
                 System.out.println("It is not a palindrome.");
             }

             System.out.println("Do you want to continue? (y/n):");
             choice = scanner.next().charAt(0);
             scanner.nextLine();

         } while (choice == 'y' || choice == 'Y');

         System.out.println("Exiting...!");
         scanner.close();
     } catch (Exception e) {
         e.printStackTrace();
     }
 }
}
